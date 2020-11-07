package com.nextleap.itr.generatexml.itr1.model.incomededuction;

import java.math.BigInteger;
import java.util.List;

import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;


public class DeductionUs57iia extends DataObject{

	public void updateModelProperties(List<IncomeOthSrc> incomeOthrSrcList){

			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.deductionUs57iia",getAmount(incomeOthrSrcList));
	}

	
	public String getAmount(List<IncomeOthSrc> incomeOthrSrcList) {
		BigInteger deductionUs57iia =  new BigInteger("0");
		for (IncomeOthSrc incomeOthrSrc : incomeOthrSrcList)
		{
			if(incomeOthrSrc.getType().equals("FAP")){
				deductionUs57iia = new BigInteger(incomeOthrSrc.getAmount());
				deductionUs57iia = deductionUs57iia.divide(new BigInteger("3"));
			}
		}

		if (deductionUs57iia.compareTo(new BigInteger("15000")) == 1) {
			// the value is more than the limit
			deductionUs57iia = new BigInteger("15000");
		}

		return deductionUs57iia.toString();
	}


	@Override
	public void updateModelProperties() {
		// TODO Auto-generated method stub
		
	}



}
