package com.nextleap.itr.generatexml.itr1.model.incomededuction;

import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;


public class Section80DDB extends DataObject {

	@Override
	public void updateModelProperties(){
		if(!isRequired()){
			return;
		}
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.usrDeductUndChapVIA.section80DDBUsrType",getType());
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.usrDeductUndChapVIA.section80DDB_Usr", getAmount());
		
	}

}
