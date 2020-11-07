package com.nextleap.itr.generatexml.itr1.model.incomededuction;

import java.math.BigInteger;
import java.util.List;

import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.personalinfo.GeneralInfo;


public class Section80TTA {


	public void updateModelProperties(GeneralInfo generalInfo,List<IncomeOthSrc> incomeOthrSrcList){
		if(!generalInfo.isSeniorCitizen()){
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.usrDeductUndChapVIA.section80TTA_Usr",getAmount(incomeOthrSrcList));
		}
	}

	public String getAmount(List<IncomeOthSrc> incomeOthrSrcList) {
		BigInteger amount =  new BigInteger("0");
			for (IncomeOthSrc incomeOthrSrc : incomeOthrSrcList)
			{
				if(incomeOthrSrc.getType().equals("SAV")){
					if(incomeOthrSrc.getAmount() == null || incomeOthrSrc.getAmount().isEmpty()){
						continue;
					}
					amount = amount.add(new BigInteger(incomeOthrSrc.getAmount()));
				}
			}

		return amount.toString();
	}

}