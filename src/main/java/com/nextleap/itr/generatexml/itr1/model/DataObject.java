package com.nextleap.itr.generatexml.itr1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itd.efiling.offline.common.onchange.util.OnChangeCommonUtil;
import com.nextleap.itr.generatexml.GenerateXMLUtility;

@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class DataObject {
	
	public void updateModelPropertiesForDataObject(){
		if(!isRequired()){
			return;
		}
		updateModelProperties();
	}

	public abstract void updateModelProperties();
	
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		if(amount == null || amount.isEmpty()){
			this.amount = "0";
			return;
		}
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}
	
	@JsonProperty(value="amount")
	String amount="0";
	
	@JsonProperty(value="id")
	String id;
	
	@JsonProperty(value="type")
	String type;

	@JsonProperty(value="doc")
	String description;
	
	@JsonProperty(value="required")
	boolean required=false;
	
	public void updateProperty(String target,String input){
		Object data = GenerateXMLUtility.getObjectFromInput(target, input);
		if(data == null){
			return;
		}
		OnChangeCommonUtil.setElementValueByTargetName(target, data);
	}
	
	public void updateOnChangedProperty(String target,String input){
		Object data = GenerateXMLUtility.getObjectFromInput(target, input);
		if(data == null){
			return;
		}
		OnChangeCommonUtil.executeOnChangeMethod(target,data);
	}


}
