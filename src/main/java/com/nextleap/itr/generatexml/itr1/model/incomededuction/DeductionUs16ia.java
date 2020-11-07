package com.nextleap.itr.generatexml.itr1.model.incomededuction;

import java.math.BigInteger;

import com.fasterxml.jackson.databind.JsonNode;
import com.itd.efiling.offline.ITR1.onchange.util.OnChangeUtil;
import com.nextleap.itr.bean.LimitRules;
import com.nextleap.itr.bean.Limits;
import com.nextleap.itr.generatexml.GenerateXMLUtility;


public class DeductionUs16ia implements Limits{

	public void updateModelProperties(){
		String amount =LimitRules.getInstance().getLimit(this, "standarddeduction");
		BigInteger amountInInt = new BigInteger(amount);
		BigInteger netSalary16 = OnChangeUtil.getElementValueByTargetNameBig("itr.itr1.itr1IncomeDeductions.netSalary");
		if ((amountInInt != null) && (amountInInt.compareTo(netSalary16) == 1)){
			// net salary is less than standard deduction.. hence will use net salary amount
			amountInInt = netSalary16;
		}
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.deductionUs16ia",amountInInt.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getLimit(JsonNode section, String key) {
		return (T)section.path(key).asText();
	}

}
