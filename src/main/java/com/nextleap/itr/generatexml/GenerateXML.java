package com.nextleap.itr.generatexml;

import java.io.File;
import java.util.logging.Handler;
import java.util.logging.LogManager;

import com.itd.efiling.offline.common.logging.util.LoggerManager;
import com.nextleap.itr.generatexml.itr1.ITR1XML;
import com.nextleap.itr.utilities.ProductDirectory;

public class GenerateXML 
{

	static{
		Handler [] handlers = LoggerManager.LOG.getHandlers();
		if(handlers!=null){
			for(Handler handler:handlers){
				LoggerManager.LOG.removeHandler(handler);
			}
		}
		LogManager.getLogManager().reset();
	}
	
	public static void main( String[] args )
	{
		GenerateXML xml = new GenerateXML();
		xml.generateXML();
	}
	
	public String generateXML(){
		return generateXML(ProductDirectory.getITR1JsonFile().toFile(),ProductDirectory.getITR1XMLFileName());
	}


	public String generateXML(File itrjsonfile,String xmlFileName){
		ITR1XML itr1xml = new ITR1XML();
		itr1xml.load();
		String xmlOutput = itr1xml.generateXML(itrjsonfile,xmlFileName);
		itr1xml.quit();
		return xmlOutput;
	}

}
