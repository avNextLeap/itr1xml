package com.nextleap.itr.generatexml.itr1.model.incomededuction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextleap.itr.generatexml.itr1.model.DataObject;

public class AllownceExemptUs10Details extends DataObject {

	@JsonProperty(value="description")
	private String exceptionDescription;
	
	
	public String getExceptionDescription() {
		return exceptionDescription;
	}


	public void setExceptionDescription(String exceptionDescription) {
		this.exceptionDescription = exceptionDescription;
	}


	@Override
	public void updateModelProperties(){
		
//		GenerateXMLUtility.setElementValueByTargetName("extentExemptController.type.salNatureDesc",getType());
//		GenerateXMLUtility.setElementValueByTargetName("extentExemptController.type.salOthAmount",getAmount());
		
	}
	
}
