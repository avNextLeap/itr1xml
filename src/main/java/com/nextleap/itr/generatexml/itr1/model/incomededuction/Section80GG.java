package com.nextleap.itr.generatexml.itr1.model.incomededuction;

import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;


public class Section80GG extends DataObject{

	@Override
	public void updateModelProperties(){
		
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.usrDeductUndChapVIA.section80GG_Usr",getAmount());
		
	}

}
