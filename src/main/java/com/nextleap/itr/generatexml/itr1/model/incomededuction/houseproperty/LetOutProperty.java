package com.nextleap.itr.generatexml.itr1.model.incomededuction.houseproperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LetOutProperty extends House{

	public String getTypeOfHP() {
		return typeOfHP;
	}

	public void setTypeOfHP(String typeOfHP) {
		this.typeOfHP = typeOfHP;
	}


	public String getGrosRentReceived() {
		return grosRentReceived;
	}

	public void setGrosRentReceived(String grosRentReceived) {
		this.grosRentReceived = grosRentReceived;
	}

	public String getTaxPaidlocalAuth() {
		return taxPaidlocalAuth;
	}

	public void setTaxPaidlocalAuth(String taxPaidlocalAuth) {
		this.taxPaidlocalAuth = taxPaidlocalAuth;
	}

	
	@JsonProperty(value="typeOfHP")
	String typeOfHP="L";
	
	@JsonProperty(value="grossRentReceived")
	String grosRentReceived="";

	@JsonProperty(value="taxPaidlocalAuth")
	String taxPaidlocalAuth="";

	
}
