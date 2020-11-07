package com.nextleap.itr.utilities;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.UUID;

public class ProductDirectory {


	public static Path getInstallDirectory() {
		String confDir = System.getProperty("install.dir");
		if(confDir == null) {
			confDir = "/generatexml";
		}
		return FileSystems.getDefault().getPath(confDir);
	}

	public static Path getTempDirectory(){
		String tempDir = System.getProperty("temp.dir");
		if(tempDir == null){
			tempDir = getInstallDirectory().toAbsolutePath().toString(); 
		}
		if(tempDir == null){
			tempDir = System.getProperty("java.io.tmpdir");
		}
		
		Path tempPath = FileSystems.getDefault().getPath(tempDir);
		if(!tempPath.toFile().exists()){
			tempPath.toFile().mkdir();
		}
		return tempPath;	

	}

	public static Path getLogDirectory() {

		String logDir = System.getProperty("itrxml.log.dir");
		if(logDir == null) {
			logDir = getInstallDirectory()+File.separator+"logs";
		}
		return FileSystems.getDefault().getPath(logDir);
	}

	public static Path getRulesDirectory() {
		String confDir = System.getProperty("generatexml.rules.dir");
		if(confDir == null) {
			confDir = getInstallDirectory()+File.separator+"resources"+File.separator+"rules";
		}
		return FileSystems.getDefault().getPath(confDir);
	}

	
	public static Path getRulesLimitFile(){
		return FileSystems.getDefault().getPath(getRulesDirectory() + File.separator + "limits.json");
			
	}
	
	public static Path getConfDirectory() {
		String confDir = System.getProperty("generatexml.conf.dir");
		if(confDir == null) {
			confDir = getInstallDirectory()+File.separator+"resources"+File.separator+"conf";
		}
		return FileSystems.getDefault().getPath(confDir);
	}

//	public static Path getXMLOutDir(){
//
//        String xmlOutDir = System.getProperty("xml.out.dir");
//        if(xmlOutDir  == null) {
//                xmlOutDir  = getInstallDirectory() + File.separator + "xml";
//        }
//        return FileSystems.getDefault().getPath(xmlOutDir);
//}
	
	public static Path getConfigFile() {
		String conifFile = System.getProperty("generatexml.conf.file","config.json");
		return FileSystems.getDefault().getPath(getConfDirectory() + File.separator + conifFile);
	}

	public static Path getLog4jConfigFile() {
		return FileSystems.getDefault().getPath(getConfDirectory() + File.separator + "log4j2.xml");
	}

	public static String getITR1XMLFileName() {
		String xmlFileName = System.getProperty("xml.file.name");
		if(xmlFileName == null) {
			xmlFileName = UUID.randomUUID().toString();
		}
		return xmlFileName;
	}


	public static Path getITR1JsonFile() {
		String templateDir = System.getProperty("json.file");
		if(templateDir == null) {
			templateDir = getInstallDirectory().toString()+File.separator+"json"+File.separator+"ITR1.json";
		}
		return FileSystems.getDefault().getPath(templateDir);
	}


}
