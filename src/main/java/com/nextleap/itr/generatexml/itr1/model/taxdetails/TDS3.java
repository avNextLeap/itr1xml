package com.nextleap.itr.generatexml.itr1.model.taxdetails;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itd.efiling.offline.ITR1.model.ScheduleTDS3Dtls;
import com.itd.efiling.offline.ITR1.model.TDS3Details;
import com.itd.efiling.offline.common.validation.validators.ValidationUtil;
import com.itd.efiling.offline.javafx.ui.components.TableViewController;
import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;

public class TDS3 extends DataObject{

	public void updateProperties(ScheduleTDS3Dtls scheduleTDS3Dtls){
		
		List<TDS3Details> list = ((TableViewController)ValidationUtil.ALL_TVC.get("class com.itd.efiling.offline.ITR1.ctrl.TaxDeductedFrmSource")).getTableView().getItems();
		
		
		
		List<TDS3Details> TDS3DetailsList  =  scheduleTDS3Dtls.getTds3Details();
		if(TDS3DetailsList == null){
			TDS3DetailsList = new ArrayList<TDS3Details>();
			scheduleTDS3Dtls.setTds3Details(TDS3DetailsList);
		}
		TDS3Details tds3Details = getTDS3DetailsModel();
		TDS3DetailsList.add(tds3Details);
		list.add(tds3Details);
		
	}
	
	private TDS3Details getTDS3DetailsModel(){
		TDS3Details tds3 = new TDS3Details(); 
		tds3.setNameOfTenant(getNameOfTenant());
		tds3.setPanOfTenant(getPanOfTenant());
		tds3.setDeductedYr(getDeductedYr());

		BigInteger grsRcptToTaxDeduct = new BigInteger(getGrsRcptToTaxDeduct());
		tds3.setGrsRcptToTaxDeduct(grsRcptToTaxDeduct);
		
		BigInteger tdsDeducted = new BigInteger(getTdsDeducted());
		tds3.setTdsDeducted(tdsDeducted);
		
		BigInteger tdsClaimed = new BigInteger(getTdsClaimed());
		tds3.setTdsClaimed(tdsClaimed);
		
		return tds3;
	}
	
	@Override
	public void updateModelProperties(){
													   
		GenerateXMLUtility.setElementValueByTargetName("taxDeductedFrmSourceController.type.panOfTenant",getPanOfTenant());
		GenerateXMLUtility.setElementValueByTargetName("taxDeductedFrmSourceController.type.nameOfTenant",getNameOfTenant());
		GenerateXMLUtility.setElementValueByTargetName("taxDeductedFrmSourceController.type.grsRcptToTaxDeduct",getGrsRcptToTaxDeduct());
		GenerateXMLUtility.setElementValueByTargetName("taxDeductedFrmSourceController.type.deductedYr",getDeductedYr());
		GenerateXMLUtility.setElementValueByTargetName("taxDeductedFrmSourceController.type.tdsDeducted",getTdsDeducted());
		GenerateXMLUtility.setElementValueByTargetName("taxDeductedFrmSourceController.type.tdsClaimed",getTdsClaimed());
	}
	


	
	public String getPanOfTenant() {
		return panOfTenant;
	}

	public void setPanOfTenant(String panOfTenant) {
		this.panOfTenant = panOfTenant;
	}

	public String getNameOfTenant() {
		return nameOfTenant;
	}

	public void setNameOfTenant(String nameOfTenant) {
		this.nameOfTenant = nameOfTenant;
	}

	public String getGrsRcptToTaxDeduct() {
		return grsRcptToTaxDeduct;
	}

	public void setGrsRcptToTaxDeduct(String grsRcptToTaxDeduct) {
		this.grsRcptToTaxDeduct = grsRcptToTaxDeduct;
	}

	public String getDeductedYr() {
		return deductedYr;
	}

	public void setDeductedYr(String deductedYr) {
		this.deductedYr = deductedYr;
	}

	public String getTdsDeducted() {
		return tdsDeducted;
	}

	public void setTdsDeducted(String tdsDeducted) {
		this.tdsDeducted = tdsDeducted;
	}

	public String getTdsClaimed() {
		return tdsClaimed;
	}

	public void setTdsClaimed(String tdsClaimed) {
		this.tdsClaimed = tdsClaimed;
	}


	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}


	@JsonProperty(value="required")
	private boolean required=false;



	@JsonProperty(value="panOfTenant")
	private String panOfTenant;
	
	@JsonProperty(value="nameOfTenant")
	private String nameOfTenant;

	@JsonProperty(value="grsRcptToTaxDeduct")
	private String grsRcptToTaxDeduct;

	@JsonProperty(value="deductedYr")
	private String deductedYr;

	@JsonProperty(value="tdsDeducted")
	private String tdsDeducted;

	@JsonProperty(value="tdsClaimed")
	private String tdsClaimed;

	
}
