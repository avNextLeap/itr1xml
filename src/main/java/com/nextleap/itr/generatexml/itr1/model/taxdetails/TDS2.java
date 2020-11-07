package com.nextleap.itr.generatexml.itr1.model.taxdetails;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itd.efiling.offline.ITR1.model.EmployerOrDeductorOrCollectDetl;
import com.itd.efiling.offline.ITR1.model.TDSonOthThanSal;
import com.itd.efiling.offline.ITR1.model.TDSonOthThanSals;
import com.itd.efiling.offline.common.validation.validators.ValidationUtil;
import com.itd.efiling.offline.javafx.ui.components.TableViewController;
import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;

public class TDS2 extends DataObject{

	public void updateProperties(TDSonOthThanSals tdsonOthThanSals){
		
		List<TDSonOthThanSal> list = ((TableViewController)ValidationUtil.ALL_TVC.get("class com.itd.efiling.offline.ITR1.ctrl.TaxDeductedFrmIncome")).getTableView().getItems();
		
		List<TDSonOthThanSal> tDSonOtherThanSalList  =  tdsonOthThanSals.getTdSonOthThanSal();
		if(tDSonOtherThanSalList == null){
			tDSonOtherThanSalList = new ArrayList<TDSonOthThanSal>();
			tdsonOthThanSals.setTdSonOthThanSal(tDSonOtherThanSalList);
		}
		TDSonOthThanSal tdsOtherThanSal = getTDSonOthThanSalModel();
		tDSonOtherThanSalList.add(tdsOtherThanSal);
		list.add(tdsOtherThanSal);
		
	}
	
	private TDSonOthThanSal getTDSonOthThanSalModel(){
		TDSonOthThanSal othrSal = new TDSonOthThanSal(); 
		EmployerOrDeductorOrCollectDetl empDetail = new EmployerOrDeductorOrCollectDetl();
		empDetail.setTan(getDeductorTan());
		empDetail.setEmployerOrDeductorOrCollecterName(getDeductorName());
		othrSal.setEmployerOrDeductorOrCollectDetl(empDetail);
		othrSal.setDeductedYr(getDeductedYr());
		BigInteger amtForTaxDeduct = new BigInteger(getAmtForTaxDeduct());
		othrSal.setAmtForTaxDeduct(amtForTaxDeduct);
		BigInteger claimOutOfTotTDSOnAmtPaid = new BigInteger(getClaimOutOfTotTDSOnAmtPaid());
		othrSal.setClaimOutOfTotTDSOnAmtPaid(claimOutOfTotTDSOnAmtPaid);
		BigInteger totTDSOnAmtPaid = new BigInteger(getTotTDSOnAmtPaid());
		othrSal.setTotTDSOnAmtPaid(totTDSOnAmtPaid);
		return othrSal;
	}
	
	@Override
	public void updateModelProperties(){
													   
		GenerateXMLUtility.setElementValueByTargetName("taxDeductedFrmIncomeController.type.employerOrDeductorOrCollectDetl.tan",getDeductorTan());
		GenerateXMLUtility.setElementValueByTargetName("taxDeductedFrmIncomeController.type.employerOrDeductorOrCollectDetl.employerOrDeductorOrCollecterName",getDeductorName());
		GenerateXMLUtility.setElementValueByTargetName("taxDeductedFrmIncomeController.type.amtForTaxDeduct",getAmtForTaxDeduct());
		GenerateXMLUtility.setElementValueByTargetName("taxDeductedFrmIncomeController.type.deductedYr",getDeductedYr());
		GenerateXMLUtility.setElementValueByTargetName("taxDeductedFrmIncomeController.type.totTDSOnAmtPaid",getTotTDSOnAmtPaid());
		GenerateXMLUtility.setElementValueByTargetName("taxDeductedFrmIncomeController.type.claimOutOfTotTDSOnAmtPaid",getClaimOutOfTotTDSOnAmtPaid());
	}
	
	

	public String getDeductorTan() {
		return deductorTan;
	}

	public void setDeductorTan(String deductorTan) {
		this.deductorTan = deductorTan;
	}

	public String getDeductorName() {
		return deductorName;
	}

	public void setDeductorName(String deductorName) {
		this.deductorName = deductorName;
	}

	public String getAmtForTaxDeduct() {
		return amtForTaxDeduct==null || amtForTaxDeduct.isEmpty()?"0":amtForTaxDeduct ;
	}

	public void setAmtForTaxDeduct(String amtForTaxDeduct) {
		this.amtForTaxDeduct = amtForTaxDeduct;
	}

	public String getDeductedYr() {
		return deductedYr;
	}

	public void setDeductedYr(String deductedYr) {
		this.deductedYr = deductedYr;
	}

	public String getTotTDSOnAmtPaid() {
		return totTDSOnAmtPaid ==null || totTDSOnAmtPaid.isEmpty()?"0":totTDSOnAmtPaid;
	}

	public void setTotTDSOnAmtPaid(String totTDSOnAmtPaid) {
		this.totTDSOnAmtPaid = totTDSOnAmtPaid;
	}

	public String getClaimOutOfTotTDSOnAmtPaid() {
		return claimOutOfTotTDSOnAmtPaid == null || claimOutOfTotTDSOnAmtPaid.isEmpty()?"0":claimOutOfTotTDSOnAmtPaid;
	}

	public void setClaimOutOfTotTDSOnAmtPaid(String claimOutOfTotTDSOnAmtPaid) {
		this.claimOutOfTotTDSOnAmtPaid = claimOutOfTotTDSOnAmtPaid;
	}


	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}


	@JsonProperty(value="required")
	private boolean required=false;



	
	@JsonProperty(value="deductorTan")
	private String deductorTan;
	
	@JsonProperty(value="deductorName")
	private String deductorName;

	@JsonProperty(value="grossIncome")
	private String amtForTaxDeduct="0";

	@JsonProperty(value="deductedYr")
	private String deductedYr;

	@JsonProperty(value="tdsDeducted")
	private String totTDSOnAmtPaid="0";

	@JsonProperty(value="tdsClaimed")
	private String claimOutOfTotTDSOnAmtPaid="0";

	
}
