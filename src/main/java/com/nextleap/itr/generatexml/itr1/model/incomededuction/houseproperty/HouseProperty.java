package com.nextleap.itr.generatexml.itr1.model.incomededuction.houseproperty;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.nextleap.itr.bean.LimitRules;
import com.nextleap.itr.bean.Limits;
import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;

@JsonIgnoreProperties(ignoreUnknown=true)
public class HouseProperty extends DataObject implements Limits{

	public SelfOccupiedProperty getSelfOccupied() {
		return selfOccupied;
	}

	public void setSelfOccupied(SelfOccupiedProperty selfOccupied) {
		this.selfOccupied = selfOccupied;
	}

	public LetOutProperty getLetOut() {
		return letOut;
	}

	public void setLetOut(LetOutProperty letOut) {
		this.letOut = letOut;
	}

	public DeemedLetoutProperty getDeemedLetoutProperty() {
		return deemedLetoutProperty;
	}

	public void setDeemedLetoutProperty(DeemedLetoutProperty deemedLetoutProperty) {
		this.deemedLetoutProperty = deemedLetoutProperty;
	} 

	@Override
	public void updateModelProperties(){
		if(getType() == null || getType().isEmpty()){
			// no valid house property type is mentioned ;
			return;
		}
		if("S".equals(getType())){
			String limitOfInterestPaybale = LimitRules.getInstance().getLimit(this, "S.interestPayable");
			BigInteger limit = new BigInteger(limitOfInterestPaybale);
			BigInteger enteredValue = new BigInteger(getSelfOccupied().getInterestPaybale());
			String calculatedmount = enteredValue.min(limit).toString();

			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.typeOfHP", getType());
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.interestPayable", calculatedmount);
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.arrearsUnrealizedRentRcvd", getSelfOccupied().getArrearsRent());
		}
		if("L".equals(getType())){
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.typeOfHP", getType());
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.grossRentReceived", getLetOut().getGrosRentReceived());
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.taxPaidlocalAuth", getLetOut().getTaxPaidlocalAuth());
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.interestPayable", getLetOut().getInterestPaybale());
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.arrearsUnrealizedRentRcvd", getLetOut().getArrearsRent());
			
			
		}
		if("D".equals(getType())){
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.typeOfHP", getType());
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.grossRentReceived", getDeemedLetoutProperty().getGrosRentReceived());
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.taxPaidlocalAuth", getDeemedLetoutProperty().getTaxPaidlocalAuth());
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.interestPayable", getDeemedLetoutProperty().getInterestPaybale());
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.arrearsUnrealizedRentRcvd", getDeemedLetoutProperty().getArrearsRent());
		}
		
		// TODO means the type in the json is not a valid type.. return appropriate error
		
	}

	@Override
	public <T> T getLimit(JsonNode section, String key) {
		return (T)section.path(key).asText();
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty(value="type")
	String type;

	@JsonProperty(value="S")
	SelfOccupiedProperty selfOccupied;
	
	@JsonProperty(value="L")
	LetOutProperty letOut; 

	@JsonProperty(value="D")
	DeemedLetoutProperty deemedLetoutProperty;


}
