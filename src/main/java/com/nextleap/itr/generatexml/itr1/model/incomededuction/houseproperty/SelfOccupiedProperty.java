package com.nextleap.itr.generatexml.itr1.model.incomededuction.houseproperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SelfOccupiedProperty extends House{

	@JsonProperty(value="typeOfHP")
	private String typeOfHP="S";



	public String getTypeOfHP() {
		return typeOfHP;
	}

	public void setTypeOfHP(String typeOfHP) {
		this.typeOfHP = typeOfHP;
	}


}
