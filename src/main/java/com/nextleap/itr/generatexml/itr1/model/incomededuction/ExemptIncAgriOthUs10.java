package com.nextleap.itr.generatexml.itr1.model.incomededuction;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.itd.efiling.offline.ITR1.model.ExemptIncAgriOthUs10Dtls;
import com.itd.efiling.offline.ITR1.model.ITR1IncomeDeductions;
import com.itd.efiling.offline.ITR1.model.OthersInc;
import com.itd.efiling.offline.common.validation.validators.ValidationUtil;
import com.itd.efiling.offline.javafx.ui.components.TableViewController;
import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;


public class ExemptIncAgriOthUs10 extends DataObject{

	private ExemptIncAgriOthUs10Dtls getExemptIncAgriOthUs10Dtls(){
		ExemptIncAgriOthUs10Dtls obj = new ExemptIncAgriOthUs10Dtls();
		obj.setNatureDesc(getType());
		obj.setOthNatOfInc(getDescription());
		BigInteger value = new BigInteger(getAmount());
		obj.setOthAmount(value);
		return obj;
	}
	
	public void updateModelProperties(ITR1IncomeDeductions itr1IncmeDedcutionmodel){
		
		 List<ExemptIncAgriOthUs10Dtls> list = ((TableViewController)ValidationUtil.ALL_TVC.get("class com.itd.efiling.offline.ITR1.ctrl.Nature_Income")).getTableView().getItems();
		OthersInc othersIncExemptUs10 = itr1IncmeDedcutionmodel.getOthersIncExemptUs10();
		if(othersIncExemptUs10 == null){
			othersIncExemptUs10 = new  OthersInc();
			itr1IncmeDedcutionmodel.setOthersIncExemptUs10(othersIncExemptUs10);
		}
		List<ExemptIncAgriOthUs10Dtls> exemptIncAgriOthUs10Dtls = othersIncExemptUs10.getExemptIncAgriOthUs10Dtls();
		if(exemptIncAgriOthUs10Dtls == null){
			exemptIncAgriOthUs10Dtls = new ArrayList<>();
			othersIncExemptUs10.setExemptIncAgriOthUs10Dtls(exemptIncAgriOthUs10Dtls);
		}
		ExemptIncAgriOthUs10Dtls obj = getExemptIncAgriOthUs10Dtls();
		exemptIncAgriOthUs10Dtls.add(obj);
		list.add(obj);
		
		GenerateXMLUtility.setElementValueByTargetName("natureIncomeController.type.natureDesc",getType());
		GenerateXMLUtility.setElementValueByTargetName("natureIncomeController.type.othAmount",getAmount());
		
	}

	@Override
	public void updateModelProperties() {
		// TODO Auto-generated method stub
		
	}


}
