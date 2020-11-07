package com.nextleap.itr.generatexml.itr1.model.incomededuction.section80D;

import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;

public class MedicalExpenditure extends DataObject {

	public void updateModelProperties(String key){
		
		GenerateXMLUtility.setElementValueByTargetName(key, getAmount());

		//GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.usrDeductUndChapVIA.section80DHealthInsPremium.medicalExpenditure",getType());
		//GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.usrDeductUndChapVIA.section80DHealthInsPremium.sec80DMedicalExpenditureUsr", getAmount());
		
	}

	@Override
	public void updateModelProperties() {
		// TODO Auto-generated method stub
		
	}


}
