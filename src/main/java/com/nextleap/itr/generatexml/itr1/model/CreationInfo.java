package com.nextleap.itr.generatexml.itr1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreationInfo {
	
	public String getSWVersionNo() {
		return SWVersionNo;
	}

	public void setSWVersionNo(String sWVersionNo) {
		SWVersionNo = sWVersionNo;
	}

	public String getSWCreatedBy() {
		return SWCreatedBy;
	}

	public void setSWCreatedBy(String sWCreatedBy) {
		SWCreatedBy = sWCreatedBy;
	}

	public String getXMLCreatedBy() {
		return XMLCreatedBy;
	}

	public void setXMLCreatedBy(String xMLCreatedBy) {
		XMLCreatedBy = xMLCreatedBy;
	}

	public String getIntermediaryCity() {
		return intermediaryCity;
	}

	public void setIntermediaryCity(String intermediaryCity) {
		this.intermediaryCity = intermediaryCity;
	}

	public String getSecretKey() {
		return SecretKey;
	}

	public void setSecretKey(String secretKey) {
		SecretKey = secretKey;
	}

	public String getIterationCount() {
		return iterationCount;
	}

	public void setIterationCount(String iterationCount) {
		this.iterationCount = iterationCount;
	}

	
	@JsonProperty(value="SWVersionNo")
	private String SWVersionNo;

	@JsonProperty(value="SWCreatedBy")
	private String SWCreatedBy;

	@JsonProperty(value="XMLCreatedBy")
	private String XMLCreatedBy;

	@JsonProperty(value="IntermediaryCity")
	private String intermediaryCity;

	@JsonProperty(value="SecretKey")
	private String SecretKey;

	@JsonProperty(value="IterationCount")
	private String iterationCount;

	
}
