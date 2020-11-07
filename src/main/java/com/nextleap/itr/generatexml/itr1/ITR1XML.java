package com.nextleap.itr.generatexml.itr1;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.itd.efiling.offline.ITR1.ctrl.ITRView;
import com.itd.efiling.offline.common.reference.holders.RefHolders;
import com.itd.efiling.offline.common.validation.validators.ValidationUtil;
import com.nextleap.itr.bean.XMLConfig;
import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.CreationInfo;
import com.nextleap.itr.generatexml.itr1.model.ITR1;
import com.nextleap.itr.generatexml.itr1.model.donation80GGA.Donation80GGA;
import com.nextleap.itr.utilities.ITRXMLLogger;
import com.nextleap.itr.utilities.JsonHelper;

import javafx.embed.swing.JFXPanel;

public class ITR1XML {

	private Map<String,String> properties = new HashMap<>();
	private com.itd.efiling.offline.ITR1.model.ITR1 itr1model;
	private ITRView itrView;
	private ITRXMLLogger logger = ITRXMLLogger.getLogger(ITR1XML.class);

	public  void load(){
		new JFXPanel();
		itrView = new ITRView();
		itr1model = itrView.getItr().getItr1();
	}

	public void quit()
	{
		javafx.application.Platform.exit();
		
	}

	private void buildITRConfig(){
		try {
			XMLConfig config = XMLConfig.getInstance(); 
			// map the user configued details to the actual ITR model object
			CreationInfo cInfo = config.getCreateInfo();
			itr1model.getCreationInfo().setIntermediaryCity(cInfo.getIntermediaryCity());
			itr1model.getCreationInfo().setSWCreatedBy(cInfo.getSWCreatedBy());
			itr1model.getCreationInfo().setXMLCreatedBy(cInfo.getXMLCreatedBy());
			itr1model.getCreationInfo().setSWVersionNo(cInfo.getSWVersionNo());
		} catch (Exception ex) {
			// TODO add logging
		}
	}

	private void buildITRProperties(File itrjson){

		try {
			ITR1 itr1 = JsonHelper.convert(JsonHelper.readFile(itrjson),ITR1.class);
			itr1.getGeneralInfo().updateProperties();
			itr1.getIncomeDeductions().updateProperties(itrView,itr1model.getItr1IncomeDeductions(),itr1.getGeneralInfo());
			itr1.getTaxDetails().updateProperties(itr1model.getTdSonSalaries(),itr1model.getTdSonOthThanSals(),itr1model.getScheduleTDS3Dtls(),itr1model.getTaxPayments());
			itr1.getVerification().updateModelProperties(itr1model.getRefund().getBankAccountDtls());
			if(itr1.getDonation80G()!=null){
				itr1.getDonation80G().updateProperties(itr1model.getSchedule80G());
			}
			if(itr1.getDonation80GGA()!=null){
				for(Donation80GGA donation80GGA:itr1.getDonation80GGA()){
					donation80GGA.setSchedule80GGA(itr1model.getSchedule80GGA());
					donation80GGA.updateModelPropertiesForDataObject();
				}
			}
		} catch (Exception e) {
			logger.error("[buildITRProperties] failed to buold the XML from the ITR Json properties", e);
		}
		
	}

	public String generateXML(File itrjson,String xmlName){
		GenerateXMLUtility.setElementzero();
		buildITRConfig();
		buildITRProperties(itrjson);
		//recalculate all the taxes before generating the xml
		com.itd.efiling.offline.common.onchange.util.OnChangeCommonUtil.executeOnChangeMethodForxmlGen((com.itd.efiling.offline.javafx.ui.components.ValidationAware)ValidationUtil.ALL_FIELDS_MAP.get("submit.call"));
		try
		{
			Path outDir = Paths.get(itrjson.getParentFile().getAbsolutePath());
			Files.createDirectories(outDir);
			GenerateXMLUtility.generateXml(itrView, outDir.toString(),xmlName);
			logger.info("[generateXML] XML genarated at : " + RefHolders.outputFileSave);
		}
		catch (Exception e1) {
			logger.error("[generateXML] Failed to generate the XML",e1);
			return "";
		}
		return RefHolders.outputFileSave.toString();
	}

	public Map<String, String> getProperties() {
		return properties;
	}
}
