package com.nextleap.itr.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import org.mvel2.MVEL;

public class Utility {

	public static Map<String,String> getTemplate(String templateName){
		Map<String,String> templateData = new HashMap<>();
		Path templateDir = ProductDirectory.getConfDirectory();
		
		try {
			templateData = (Map<String,String>)MVEL.evalFile(new File(templateDir.toString()+File.separator+templateName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return templateData;
	}
	

}
