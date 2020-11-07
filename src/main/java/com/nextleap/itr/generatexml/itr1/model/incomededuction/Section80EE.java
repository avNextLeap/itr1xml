package com.nextleap.itr.generatexml.itr1.model.incomededuction;

import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;

public class Section80EE extends DataObject{

	@Override
	public void updateModelProperties(){
		
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.usrDeductUndChapVIA.section80EE_Usr",getAmount());
		
	}
}
