package com.nextleap.itr.generatexml.itr1.model.incomededuction.section80D;

import java.math.BigInteger;

import com.fasterxml.jackson.databind.JsonNode;
import com.nextleap.itr.bean.LimitRules;
import com.nextleap.itr.bean.Limits;
import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;

public class PreventiveHealthCheckUp extends DataObject implements Limits {
	
	public void updateModelPropertiesForParents(String key,String  selfAndFamilyPreventiveHealthCheckupAmount){
		
		String amountLimit = getLimit();
		BigInteger limit = new BigInteger(amountLimit);
		// The limit should be deducted from the self and and family preventive health checkup
		limit = limit.subtract(new BigInteger(selfAndFamilyPreventiveHealthCheckupAmount));
		BigInteger enteredValue = new BigInteger(getAmount());
		setAmount(enteredValue.min(limit).toString());
		GenerateXMLUtility.setElementValueByTargetName(key, getAmount());
		
		//GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.usrDeductUndChapVIA.section80DHealthInsPremium.preventiveHealthCheckUp",getType());
		//GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.usrDeductUndChapVIA.section80DHealthInsPremium.sec80DPreventiveHealthCheckUpUsr", getAmount());
		
	}

	
	public void updateModelPropertiesForSelfAndFamily(String key,HealthInsurancePremium healthInsurancePremium,boolean isSeniorCitizen){
		
		String amountLimit = LimitRules.getInstance().getLimit(this,"section80d","preventiveHealthCheckUp");
		BigInteger limit = new BigInteger(amountLimit);
		// The default limit is applied only if the cap of the section80D is still remaining and not used by health insurance premium
		limit = limit.min(healthInsurancePremium.getSection80DLimitUntilizedByHeathInsurance(isSeniorCitizen));
		BigInteger enteredValue = new BigInteger(getAmount());
		setAmount(enteredValue.min(limit).toString());
		GenerateXMLUtility.setElementValueByTargetName(key, getAmount());
		
		//GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.usrDeductUndChapVIA.section80DHealthInsPremium.preventiveHealthCheckUp",getType());
		//GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.usrDeductUndChapVIA.section80DHealthInsPremium.sec80DPreventiveHealthCheckUpUsr", getAmount());
		
	}

	
	@Override
	public void updateModelProperties() {
		// TODO Auto-generated method stub
	}

	public <T> T getLimit() {
		return LimitRules.getInstance().getLimit(this,"section80d","preventiveHealthCheckUp");
	}
	
	
	@Override
	public <T> T getLimit(JsonNode section, String key) {
		return (T)section.path(key).asText();
	}



}
