package com.nextleap.itr.generatexml.itr1.model.incomededuction;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itd.efiling.offline.ITR1.ctrl.ITRView;
import com.itd.efiling.offline.ITR1.model.ITR1IncomeDeductions;
import com.itd.efiling.offline.ITR1.model.OthersInc;
import com.itd.efiling.offline.ITR1.model.OthersIncDtlsOthsrc;
import com.itd.efiling.offline.common.validation.validators.ValidationUtil;
import com.itd.efiling.offline.javafx.ui.components.TableViewController;
import com.nextleap.itr.generatexml.itr1.model.DataObject;


public class IncomeOthSrc extends DataObject{
	
	@JsonProperty(value="description")
	String description ="Any Other";
	

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void updateModelProperties(
			ITRView itrView,
			ITR1IncomeDeductions itr1IncmeDedcutionmodel){
		if(!isRequired()){
			return;
		}
		
		BigInteger amount = new BigInteger(getAmount());
		if(amount.compareTo(new BigInteger("0")) == 0){
			return;
		}
		OthersIncDtlsOthsrc othrs = updateModelProperties(itr1IncmeDedcutionmodel);
		List<OthersIncDtlsOthsrc> list1a = ((TableViewController)ValidationUtil.ALL_TVC.get("class com.itd.efiling.offline.ITR1.ctrl.Income_Other_Source")).getTableView().getItems();
		list1a.add(othrs);
		updateOnChangedProperty("incomeOtherSourceController.type.othSrcOthAmount", getAmount());
	}


	private OthersIncDtlsOthsrc updateModelProperties(ITR1IncomeDeductions itr1IncmeDedcutionmodel){

		OthersInc othersInc = itr1IncmeDedcutionmodel.getOthersInc();
		if(othersInc == null){
			othersInc = new OthersInc();
			itr1IncmeDedcutionmodel.setOthersInc(othersInc);
		}

		List<OthersIncDtlsOthsrc> othersIncDtlsOthsrc= othersInc.getOthersIncDtlsOthsrc();
		if(othersIncDtlsOthsrc == null){
			othersIncDtlsOthsrc = new ArrayList<OthersIncDtlsOthsrc>();
			othersInc.setOthersIncDtlsOthsrc(othersIncDtlsOthsrc);
		}
		OthersIncDtlsOthsrc otherSrc = new OthersIncDtlsOthsrc();
		otherSrc.setOthSrcNatureDesc(getType());
		BigInteger othSrcOthAmount = new BigInteger(getAmount());
		otherSrc.setOthSrcOthAmount(othSrcOthAmount);
		if("OTH".equals(getType())){
			otherSrc.setOthSrcOthNatOfInc(this.description);
		}	
		othersIncDtlsOthsrc.add(otherSrc);
		return otherSrc;
	}


	@Override
	public void updateModelProperties() {
		// TODO Auto-generated method stub
		
	}

}
