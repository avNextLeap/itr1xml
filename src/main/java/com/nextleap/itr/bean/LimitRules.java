package com.nextleap.itr.bean;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.nextleap.itr.utilities.JsonHelper;
import com.nextleap.itr.utilities.ProductDirectory;

public class LimitRules {
	
	@JsonProperty("section")
	JsonNode section = JsonHelper.createObjectNode();

	private static LimitRules instance = new LimitRules();
	
	static{
		
		try {
			instance = JsonHelper.convert(JsonHelper.readFile(ProductDirectory.getRulesLimitFile().toFile()),LimitRules.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
	
	private LimitRules(){
		
	}
	public static LimitRules getInstance(){
		return  instance;
	}
	
	
	public void setSection(JsonNode section) {
		this.section = section;
	}
	
	public <T> T getLimit( Limits limit , String key ){
		JsonNode sectionNode = section.path(limit.getClass().getSimpleName().toLowerCase());
		return limit.getLimit(sectionNode,key);
	}

	
	public <T> T getLimit( Limits limit ,String sectionName, String key ){
		JsonNode sectionNode = section.path(sectionName);
		return limit.getLimit(sectionNode,key);
	}

	
}
