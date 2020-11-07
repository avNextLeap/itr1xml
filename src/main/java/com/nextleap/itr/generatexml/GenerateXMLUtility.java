package com.nextleap.itr.generatexml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.itd.efiling.offline.common.codec.XmlDigestUtil;
import com.itd.efiling.offline.common.config.Configs;
import com.itd.efiling.offline.common.logging.util.LoggerManager;
import com.itd.efiling.offline.common.onchange.util.OnChangeCommonUtil;
import com.itd.efiling.offline.common.player.ctrl.Form;
import com.itd.efiling.offline.common.reference.holders.RefHolders;
import com.itd.efiling.offline.common.util.CustomValidationHandler;
import com.itd.efiling.offline.common.util.XmlUtil;
import com.itd.efiling.offline.common.validation.validators.ValidationUtil;
import com.itd.efiling.offline.javafx.ui.components.ValBigDecimalField;
import com.itd.efiling.offline.javafx.ui.components.ValBigIntegerField;
import com.itd.efiling.offline.javafx.ui.components.ValCheckBox;
import com.itd.efiling.offline.javafx.ui.components.ValDatePicker;
import com.itd.efiling.offline.javafx.ui.components.ValTextField;
import com.itd.efiling.offline.javafx.ui.components.ValidationAware;
import com.nextleap.itr.bean.XMLConfig;


public class GenerateXMLUtility {

	public static final String SAVE_FILE_TYPE = ".xml";
	public static Document doc = null;
	public static void setElementzero()
	{
		Map<String, ValidationAware> allFields = ValidationUtil.ALL_FIELDS_MAP;
		Set<Entry<String,ValidationAware>> allFieldSet = allFields.entrySet();
		for(Entry<String,ValidationAware> field: allFieldSet){
			//System.out.println(field.getKey());
			if(field.getValue() instanceof ValBigIntegerField){
				OnChangeCommonUtil.setElementValueByTargetName(field.getKey(),new BigInteger("0"));		
			}
			else if(field.getValue() instanceof ValBigDecimalField){
				OnChangeCommonUtil.setElementValueByTargetName(field.getKey(),new BigInteger("0.0"));		
			}
			else if(field.getValue() instanceof ValTextField){
				OnChangeCommonUtil.setElementValueByTargetName(field.getKey(),null);		
			}
		}
	}

	public static Object getObjectFromInput(String target, String input){
		Object data = input;
		if (ValidationUtil.ALL_FIELDS_MAP.containsKey(target)) {
			OnChangeCommonUtil.flagtable2 = "true";
			if((ValidationAware)ValidationUtil.ALL_FIELDS_MAP.get(target) instanceof ValDatePicker){
				try{
					if(data instanceof String){
						Date date = new SimpleDateFormat("dd/MM/yyyy").parse((String)data);
						data = date;
					}
				}catch(Exception ex){
					//System.out.println(String.format("Date format %s is wrong ",data));
				}
			}
			if((ValidationAware)ValidationUtil.ALL_FIELDS_MAP.get(target) instanceof ValBigIntegerField){
				try{
					if(data instanceof String){
						BigDecimal dataDecimal = new BigDecimal((String)data);
						data = dataDecimal.toBigInteger();
					}
				}catch(Exception ex){
					ex.printStackTrace();
					//System.out.println(String.format("BigInteger format %s is wrong ",data));
				}
			}
			if((ValidationAware)ValidationUtil.ALL_FIELDS_MAP.get(target) instanceof ValCheckBox){
				try{
					if(data instanceof String){
						data = Boolean.parseBoolean(input);
					}
				}catch(Exception ex){
					//System.out.println(String.format("Date format %s is wrong ",data));
				}
			}
		}else{
			return null;
		}
		return data;
	}

	public static void setElementValueByTargetName(String target, String input)
	{

		if(input == null || input.isEmpty()){
			return;
		}

		Object data = getObjectFromInput(target,input);
		if(data == null){
			return;
		}

		OnChangeCommonUtil.setElementValueByTargetName(target, data);
		OnChangeCommonUtil.executeOnChangeMethod(target,data);
	}

	public static void generateXml(Form form, String xmlFilePath,String xmlName) throws IOException, JAXBException, SAXException
	{
		com.itd.efiling.offline.common.onchange.util.OnChangeCommonUtil.executeOnChangeMethodForxmlGen((com.itd.efiling.offline.javafx.ui.components.ValidationAware)ValidationUtil.ALL_FIELDS_MAP.get("submit.call"));

		if(xmlFilePath == null || xmlFilePath.isEmpty()){
			xmlFilePath = System.getProperty("java.io.tmpdir");
		}
		RefHolders.outputFileSave = new File(xmlFilePath,xmlName+SAVE_FILE_TYPE);

		if (RefHolders.outputFileSave != null) {
			CustomValidationHandler validationHandler = new CustomValidationHandler();
			try
			{
				Object entity = form.getEntity();
				JAXBContext jaxbContext = JAXBContext.newInstance(new Class[] { entity.getClass() });
				Marshaller marshaller = jaxbContext.createMarshaller();

				marshaller.setEventHandler(validationHandler);

				marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));

				marshaller.marshal(entity, RefHolders.outputFileSave);

				setDocument(RefHolders.outputFileSave);

				XmlUtil.removeExtraTags(doc);

				setDigestToFile(doc);

				boolean isSchemaValid = validateXMLSchema(RefHolders.outputFileSave);

				if (isSchemaValid)
				{

					Form.getForm().setChanged(false);

					writeToFile(RefHolders.outputFileSave, doc);
					com.itd.efiling.offline.common.player.ctrl.FormPlayerController.flag = true;
				}
				else {
					LoggerManager.LOG.info("XML Schema is invalid");
				}
			}
			catch (Exception e)
			{

				LoggerManager.LOG.info("validationHandler " + validationHandler.getErrorMessage());
				LoggerManager.LOG.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
		}
	}


	public static boolean validateXMLSchema(File xmlToBeValidated)
	{

		try
		{
			SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
			Schema schema = schemaFactory.newSchema(XmlUtil.class.getResource(Configs.getConfigProperty("xsd.file.path")));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(xmlToBeValidated));
		} catch (IOException|SAXException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void setDigestToFile(Document doc)
	{
		try
		{
			Integer t = Integer.parseInt(XMLConfig.getInstance().getCreateInfo().getIterationCount());
			String s = XMLConfig.getInstance().getCreateInfo().getSecretKey();
			String hash = XmlDigestUtil.createHash(new FileInputStream(RefHolders.outputFileSave), t,s);
			doc.getElementsByTagName("Digest").item(0).setTextContent(hash);
			writeToFile(RefHolders.outputFileSave, doc);
		}
		catch (Exception e)
		{
			LoggerManager.LOG.log(Level.SEVERE, "Error in generating the digest hash for the xml", e);
		}
	}

	private static void setDocument(File file) throws Exception { 
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		doc = dbf.newDocumentBuilder().parse(file);
	}

	private static void writeToFile(File outputFile, Document doc) throws Exception {
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty("indent", "yes");
		StreamResult result = new StreamResult(outputFile);
		DOMSource source = new DOMSource(doc);
		transformer.transform(source, result);
	}

}
