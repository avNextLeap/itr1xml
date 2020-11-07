package com.nextleap.itr.generatexml.itr1.model.taxdetails;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itd.efiling.offline.ITR1.model.EmployerOrDeductorOrCollectDetl;
import com.itd.efiling.offline.ITR1.model.TDSonSalaries;
import com.itd.efiling.offline.ITR1.model.TDSonSalary;
import com.itd.efiling.offline.common.validation.validators.ValidationUtil;
import com.itd.efiling.offline.javafx.ui.components.TableViewController;
import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;

public class TDS1 extends DataObject{

	public void updateProperties(TDSonSalaries tDSonSalaries){
		
		List<TDSonSalary> list = ((TableViewController)ValidationUtil.ALL_TVC.get("class com.itd.efiling.offline.ITR1.ctrl.TaxDeductedFrmSal")).getTableView().getItems();
		
		List<TDSonSalary> tDSonSalariesList  =  tDSonSalaries.getTdSonSalary();
		if(tDSonSalariesList == null){
			tDSonSalariesList = new ArrayList<TDSonSalary>();
			tDSonSalaries.setTdSonSalary(tDSonSalariesList);
		}
		TDSonSalary tdsSal = getTDSonSalaryModel();
		tDSonSalariesList.add(tdsSal);
		list.add(tdsSal);
		
	}
	
	private TDSonSalary getTDSonSalaryModel(){
		TDSonSalary sal = new TDSonSalary();
		EmployerOrDeductorOrCollectDetl employerOrDeductorOrCollectDetl = new EmployerOrDeductorOrCollectDetl();
		employerOrDeductorOrCollectDetl.setEmployerOrDeductorOrCollecterName(getDeductorName());
		employerOrDeductorOrCollectDetl.setTan(getDeductorTan());
		sal.setEmployerOrDeductorOrCollectDetl(employerOrDeductorOrCollectDetl);
		BigInteger value = new BigInteger(getIncChrgSal());
		sal.setIncChrgSal(value);
		BigInteger totalTDSSal = new BigInteger(getTotalTDSSal());
		sal.setTotalTDSSal(totalTDSSal);
		return sal;
	}
	
	@Override
	public void updateModelProperties(){
													   
		GenerateXMLUtility.setElementValueByTargetName("taxDetailsTabController.type.employerOrDeductorOrCollectDetl.tan",getDeductorTan());
		GenerateXMLUtility.setElementValueByTargetName("taxDetailsTabController.type.employerOrDeductorOrCollectDetl.employerOrDeductorOrCollecterName",getDeductorName());
		GenerateXMLUtility.setElementValueByTargetName("taxDetailsTabController.type.incChrgSal",getIncChrgSal());
		GenerateXMLUtility.setElementValueByTargetName("taxDetailsTabController.type.totalTDSSal",getTotalTDSSal());
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

	public String getIncChrgSal() {
		return incChrgSal == null || incChrgSal.isEmpty()?"0":incChrgSal;
	}

	public void setIncChrgSal(String incChrgSal) {
		this.incChrgSal = incChrgSal;
	}

	public String getTotalTDSSal() {
		return totalTDSSal == null || totalTDSSal.isEmpty()?"0":totalTDSSal;
	}

	public void setTotalTDSSal(String totalTDSSal) {
		this.totalTDSSal = totalTDSSal;
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

	@JsonProperty(value="grossSalary")
	private String incChrgSal="0";

	@JsonProperty(value="tdsDeducted")
	private String totalTDSSal="0";
	


}
