package com.nextleap.itr.generatexml.itr1.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextleap.itr.generatexml.itr1.model.donation80G.Donation80G;
import com.nextleap.itr.generatexml.itr1.model.donation80GGA.Donation80GGA;
import com.nextleap.itr.generatexml.itr1.model.incomededuction.IncomeDeductions;
import com.nextleap.itr.generatexml.itr1.model.personalinfo.GeneralInfo;
import com.nextleap.itr.generatexml.itr1.model.taxdetails.TaxDetails;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ITR1 {

	
	public IncomeDeductions getIncomeDeductions() {
		return incomeDeductions;
	}

	public void setIncomeDeductions(IncomeDeductions incomeDeductions) {
		this.incomeDeductions = incomeDeductions;
	}

	public TaxDetails getTaxDetails() {
		return taxDetails;
	}

	public void setTaxDetails(TaxDetails taxDetails) {
		this.taxDetails = taxDetails;
	}

	public Verification getVerification() {
		return verification;
	}

	public void setVerification(Verification verification) {
		this.verification = verification;
	}

	public Donation80G getDonation80G() {
		return donation80G;
	}

	public void setDonation80G(Donation80G donation80g) {
		donation80G = donation80g;
	}


	public List<Donation80GGA> getDonation80GGA() {
		return donation80GGA;
	}

	public void setDonation80GGA(List<Donation80GGA> donation80gga) {
		donation80GGA = donation80gga;
	}
	
	public GeneralInfo getGeneralInfo() {
		return generalInfo;
	}

	public void setGeneralInfo(GeneralInfo generalInfo) {
		this.generalInfo = generalInfo;
	}
	
	
	@JsonProperty(value = "GeneralInfo")
	GeneralInfo generalInfo;

	@JsonProperty(value = "IncomeDeductions")
	IncomeDeductions incomeDeductions = new IncomeDeductions();

	@JsonProperty(value = "TaxDetails")
	TaxDetails taxDetails = new TaxDetails();

	@JsonProperty(value = "Verification")
	Verification verification;

	@JsonProperty(value = "Donation80G")
	Donation80G donation80G;

	@JsonProperty(value = "Donation80GGA")
	List<Donation80GGA> donation80GGA;

	
	
}