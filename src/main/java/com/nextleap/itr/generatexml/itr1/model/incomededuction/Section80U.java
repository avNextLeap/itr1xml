package com.nextleap.itr.generatexml.itr1.model.incomededuction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.nextleap.itr.bean.LimitRules;
import com.nextleap.itr.bean.Limits;
import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;


public class Section80U extends DataObject implements Limits{
	

	@JsonProperty(value="claimDeduction")
	private boolean claimDeduction;

	public boolean isClaimDeduction() {
		return claimDeduction;
	}

	public void setClaimDeduction(boolean claimDeduction) {
		this.claimDeduction = claimDeduction;
	}

	@Override
	public void updateModelProperties(){
		if(!isClaimDeduction()){
			return;
		}
		setAmount(LimitRules.getInstance().getLimit(this, getType()));
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.usrDeductUndChapVIA.section80UUsrType",getType());
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.usrDeductUndChapVIA.section80U_Usr",getAmount());
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getLimit(JsonNode section, String key) {
		return (T)section.path(key).asText();
	}

	
}
