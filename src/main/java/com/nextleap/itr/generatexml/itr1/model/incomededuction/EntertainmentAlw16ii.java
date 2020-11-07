package com.nextleap.itr.generatexml.itr1.model.incomededuction;

import java.math.BigInteger;

import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;
import com.nextleap.itr.generatexml.itr1.model.personalinfo.EmplorerCategoryType;
import com.nextleap.itr.generatexml.itr1.model.personalinfo.GeneralInfo;


public class EntertainmentAlw16ii extends DataObject{


	public void updateModelProperties(GeneralInfo generalInfo,BasicSalary basicSalary){
		if(!isRequired()){
			return;
		}
		String amount  =  getAmount();
		if(generalInfo.getEmployerCategory().equals(EmplorerCategoryType.PE.name()) || 
		   generalInfo.getEmployerCategory().equals(EmplorerCategoryType.OTH.name()) ||
		   generalInfo.getEmployerCategory().equals(EmplorerCategoryType.NA.name())){
				amount= "0";
		}else{
			
			BigInteger entertainmenAllowence = new BigInteger(amount);
			BigInteger basicSalary20Percent = new BigInteger(basicSalary.getAmount()).multiply(new BigInteger("20")).divide(new BigInteger("100"));
	        entertainmenAllowence = BigInteger.valueOf(Math.min(entertainmenAllowence.longValue(),basicSalary20Percent.longValue()));
	        amount = BigInteger.valueOf(Math.min(entertainmenAllowence.longValue(),5000)).toString().toString();
		}
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.entertainmentAlw16ii",amount);
		
	}

	@Override
	public void updateModelProperties() {
		// TODO Auto-generated method stub
		
	}


}
