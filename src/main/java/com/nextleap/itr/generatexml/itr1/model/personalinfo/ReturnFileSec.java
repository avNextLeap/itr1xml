package com.nextleap.itr.generatexml.itr1.model.personalinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ReturnFileSec {

	@JsonProperty(value = "fileType")
	String fileType = "11";

//	@JsonProperty(value = "filedate")
//	String filedate = "";

	
//	public String getFiledate() {
//		return filedate;
//	}
//
//	public void setFiledate(String filedate) {
//		this.filedate = filedate;
//	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileType() {
		return fileType;
	}

	
//	enum ReturnFileType{
//		
//		BeforeDueDate("11"),
//		Belated("12");
//		
//		private String fileType;
//		ReturnFileType(String fileType){
//			this.fileType = fileType;
//		}
//		
//		public String getFileType(){
//			return fileType;
//		}
//		
//	}
}
