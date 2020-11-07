package com.nextleap.itr.generatexml.itr1.model.incomededuction;

import com.fasterxml.jackson.databind.JsonNode;
import com.nextleap.itr.bean.LimitRules;
import com.nextleap.itr.bean.Limits;
import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;


public class Section80DD extends DataObject implements Limits{

	@Override
	public void updateModelProperties(){
		if(!isRequired()){
			return;
		}
		setAmount(LimitRules.getInstance().getLimit(this, getType()));
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.usrDeductUndChapVIA.section80DDUsrType",getType());
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.usrDeductUndChapVIA.section80DD_Usr", getAmount());
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getLimit(JsonNode section, String key) {
		return (T)section.path(key).asText();
	}
}
