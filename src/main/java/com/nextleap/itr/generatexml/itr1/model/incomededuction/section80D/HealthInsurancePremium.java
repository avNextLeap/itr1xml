package com.nextleap.itr.generatexml.itr1.model.incomededuction.section80D;

import java.math.BigInteger;

import com.fasterxml.jackson.databind.JsonNode;
import com.nextleap.itr.bean.LimitRules;
import com.nextleap.itr.bean.Limits;
import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;

public class HealthInsurancePremium extends DataObject implements Limits{

	public void updateModelProperties(String key){
		
		GenerateXMLUtility.setElementValueByTargetName(key, getAmount());
		
		//GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.usrDeductUndChapVIA.section80DHealthInsPremium.healthInsurancePremium",getType());
		//GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.usrDeductUndChapVIA.section80DHealthInsPremium.sec80DHealthInsurancePremiumUsr", getAmount());
		
	}

	@Override
	public void updateModelProperties() {
		// TODO Auto-generated method stub
		
	}

	public BigInteger getSection80DLimitUntilizedByHeathInsurance(boolean isSeniorCitizen){
		String limit =  getLimit(isSeniorCitizen);
		BigInteger limitLeft = new BigInteger(limit).subtract(new BigInteger(getAmount()));
		if( limitLeft.compareTo(new BigInteger("0"))>0){
			return limitLeft;
		}
		return new BigInteger("0");
		
	}
	
	private <T> T getLimit(boolean isSeniorCitizen) {
		if(isSeniorCitizen){
			return LimitRules.getInstance().getLimit(this,"section80d","seniorCitizen.insurancePremium");
			
		}
		return LimitRules.getInstance().getLimit(this,"section80d","insurancePremium");
	}

	@Override
	public <T> T getLimit(JsonNode section, String key) {
		return (T)section.path(key).asText();
	}
	
				

}
