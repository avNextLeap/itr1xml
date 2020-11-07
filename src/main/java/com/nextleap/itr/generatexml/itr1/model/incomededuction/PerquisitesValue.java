package com.nextleap.itr.generatexml.itr1.model.incomededuction;

import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;


public class PerquisitesValue extends DataObject {

	
	@Override
	public void updateModelProperties(){
		
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.perquisitesValue",getAmount());
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.perquisitesValue",getAmount());
		
	}

}
