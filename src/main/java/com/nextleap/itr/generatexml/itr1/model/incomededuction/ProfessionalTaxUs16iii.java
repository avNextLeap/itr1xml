package com.nextleap.itr.generatexml.itr1.model.incomededuction;

import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;
import com.nextleap.itr.generatexml.itr1.model.personalinfo.EmplorerCategoryType;
import com.nextleap.itr.generatexml.itr1.model.personalinfo.GeneralInfo;


public class ProfessionalTaxUs16iii extends DataObject {

	
	public void updateModelProperties(GeneralInfo generalInfo){
		if(!isRequired()){
			return;
		}

		String amount  =  getAmount();
		if(generalInfo.getEmployerCategory().equals(EmplorerCategoryType.PE.name()) || 
				generalInfo.getEmployerCategory().equals(EmplorerCategoryType.NA.name())){
			amount= "0";
		}
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.professionalTaxUs16iii",amount);

	}

	@Override
	public void updateModelProperties() {
		// TODO Auto-generated method stub
		
	}

}
