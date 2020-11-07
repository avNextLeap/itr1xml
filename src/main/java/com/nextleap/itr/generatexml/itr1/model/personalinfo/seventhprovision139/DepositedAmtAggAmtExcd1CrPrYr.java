package com.nextleap.itr.generatexml.itr1.model.personalinfo.seventhprovision139;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class DepositedAmtAggAmtExcd1CrPrYr {
	
	public String getApplicable() {
		if("Yes".equalsIgnoreCase(applicable)){
			return "Y";
		}
		return "N";
	}
	public void setApplicable(String applicable) {
		this.applicable = applicable;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	@JsonProperty(value="applicable")
	private String applicable="No";
	
	@JsonProperty(value="amount")
	private String amount="0";
	

}
