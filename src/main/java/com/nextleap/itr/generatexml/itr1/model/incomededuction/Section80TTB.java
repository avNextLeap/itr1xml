package com.nextleap.itr.generatexml.itr1.model.incomededuction;

import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.nextleap.itr.bean.LimitRules;
import com.nextleap.itr.bean.Limits;
import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.personalinfo.GeneralInfo;


public class Section80TTB implements Limits{
	

	public void updateModelProperties(	GeneralInfo generalInfo,List<IncomeOthSrc> incomeOthrSrcList){
		
		if(generalInfo.isSeniorCitizen()){
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.usrDeductUndChapVIA.section80TTB_Usr",getAmount(incomeOthrSrcList));
		}
	}

	public String getAmount(List<IncomeOthSrc> incomeOthrSrcList) {
		BigInteger amount =  new BigInteger("0");
			// the TTB value is  set the default value as SUM of SAV+FAD
			for (IncomeOthSrc incomeOthrSrc : incomeOthrSrcList)
			{
				if(incomeOthrSrc.getType().equals("SAV") || incomeOthrSrc.getType().equals("IFD")){
					if(incomeOthrSrc.getAmount() == null || incomeOthrSrc.getAmount().isEmpty()){
						continue;
					}
					amount = amount.add(new BigInteger(incomeOthrSrc.getAmount()));
				}
			}
			
			String intrestOnDeposit = LimitRules.getInstance().getLimit(this, "intrestOnDeposit");

		return amount.min(new BigInteger(intrestOnDeposit)).toString();
	}


	@Override
	public <T> T getLimit(JsonNode section, String key) {
		return (T)section.path(key).asText();
	}

}
