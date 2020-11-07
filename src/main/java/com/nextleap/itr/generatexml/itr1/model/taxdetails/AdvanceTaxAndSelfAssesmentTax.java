package com.nextleap.itr.generatexml.itr1.model.taxdetails;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itd.efiling.offline.ITR1.model.TaxPayment;
import com.itd.efiling.offline.ITR1.model.TaxPayments;
import com.itd.efiling.offline.common.validation.validators.ValidationUtil;
import com.itd.efiling.offline.javafx.ui.components.TableViewController;
import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;
import com.nextleap.itr.utilities.ITRXMLLogger;

public class AdvanceTaxAndSelfAssesmentTax extends DataObject{

	ITRXMLLogger logger = ITRXMLLogger.getLogger(AdvanceTaxAndSelfAssesmentTax.class);
	public void updateProperties(TaxPayments taxPayments){
	
		List<TaxPayment> taxPaymentlist = ((TableViewController)ValidationUtil.ALL_TVC.get("class com.itd.efiling.offline.ITR1.ctrl.TaxPaymentController")).getTableView().getItems();
		
		List<TaxPayment> taxList  =  taxPayments.getTaxPayment();
		if(taxList == null){
			taxList = new ArrayList<TaxPayment>();
			taxPayments.setTaxPayment(taxList);
		}
		TaxPayment tax = getTaxPaymentModel();
		taxList.add(tax);
		taxPaymentlist.add(tax);
		
		GenerateXMLUtility.setElementValueByTargetName("advancedTax.type.amt",getTaxPaid());
	}
	
	private TaxPayment getTaxPaymentModel(){
		TaxPayment payment = new TaxPayment();
		payment.setBsrCode(getBsrCode());
		Date dateDep;
		try {
			dateDep = new SimpleDateFormat("dd/MM/yyyy").parse(getDateDeposited());
			payment.setDateDep(dateDep);
		} catch (ParseException e) {
			logger.error("[getTaxPaymentModel]  the date deposited entered is not in dd/mm/yyy format");
		}
		payment.setSrlNoOfChaln(getSrlNoOfChaln());
		BigInteger amount = new BigInteger(getTaxPaid());
		payment.setAmt(amount);
		return payment;
	}
	
	@Override
	public void updateModelProperties() {
		
	}

	
	
	public String getBsrCode() {
		return bsrCode;
	}

	public void setBsrCode(String bsrCode) {
		this.bsrCode = bsrCode;
	}

	public String getDateDeposited() {
		return dateDeposited;
	}

	public void setDateDeposited(String dateDeposited) {
		this.dateDeposited = dateDeposited;
	}

	public String getSrlNoOfChaln() {
		return srlNoOfChaln;
	}

	public void setSrlNoOfChaln(String srlNoOfChaln) {
		this.srlNoOfChaln = srlNoOfChaln;
	}

	public String getTaxPaid() {
		return taxPaid == null || taxPaid.isEmpty()?"0":taxPaid;
	}

	public void setTaxPaid(String taxPaid) {
		this.taxPaid = taxPaid;
	}


	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}


	@JsonProperty(value="required")
	private boolean required=false;


	@JsonProperty(value="bsrCode")
	private String bsrCode;
	
	@JsonProperty(value="dateDeposited")
	private String dateDeposited;

	@JsonProperty(value="srlNoOfChaln")
	private String srlNoOfChaln;

	@JsonProperty(value="taxPaid")
	private String taxPaid;

}
