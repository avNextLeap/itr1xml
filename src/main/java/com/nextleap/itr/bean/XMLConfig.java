package com.nextleap.itr.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextleap.itr.generatexml.itr1.model.CreationInfo;
import com.nextleap.itr.utilities.JsonHelper;
import com.nextleap.itr.utilities.ProductDirectory;

public class XMLConfig {

	private XMLConfig(){};
	
	@JsonProperty(value="CreationInfo")
	public CreationInfo createInfo;

	public CreationInfo getCreateInfo() {
		return createInfo;
	}

	public void setCreateInfo(CreationInfo createInfo) {
		this.createInfo = createInfo;
	}
	
	public static XMLConfig getInstance(){
		try {
			return JsonHelper.convert(JsonHelper.readFile(ProductDirectory.getConfigFile().toFile()),XMLConfig.class);
		} catch (Exception ex){
			return new XMLConfig();
		}
	}
}
