package com.nextleap.itr.generatexml.itr1.model.donation80GGA;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itd.efiling.offline.ITR1.model.AddressDetail;
import com.itd.efiling.offline.ITR1.model.DonationDtlsSciRsrchRuralDev;
import com.itd.efiling.offline.ITR1.model.Schedule80GGA;
import com.itd.efiling.offline.ITR1.onchange.util.OnChangeUtil;
import com.itd.efiling.offline.common.validation.validators.ValidationUtil;
import com.itd.efiling.offline.javafx.ui.components.TableViewController;
import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;

public class Donation80GGA extends DataObject{
	
	
	BigInteger donationAmt;
	BigInteger eligibleDonationAmt;

	Schedule80GGA schedule80GGA;
	
	
	public Schedule80GGA getSchedule80GGA() {
		return schedule80GGA;
	}

	public void setSchedule80GGA(Schedule80GGA schedule80gga) {
		schedule80GGA = schedule80gga;
	}
	
	private DonationDtlsSciRsrchRuralDev getDonationDtlsSciRsrchRuralDev(){
		DonationDtlsSciRsrchRuralDev doneeWithPan = new DonationDtlsSciRsrchRuralDev();
		BigInteger amountCash = new BigInteger(getDonationAmtCash());
		doneeWithPan.setDonationAmtCash(amountCash);
		BigInteger donationAmtOtherMode = new BigInteger(getDonationAmtOtherMode());
		doneeWithPan.setDonationAmtOtherMode(donationAmtOtherMode);
		doneeWithPan.setDonationAmt(donationAmt);
		doneeWithPan.setEligibleDonationAmt(eligibleDonationAmt);
		doneeWithPan.setDoneePAN(getDoneePAN());
		doneeWithPan.setNameOfDonee(getDoneeName());
		doneeWithPan.setRelevantClauseUndrDedClaimed(getType());
		AddressDetail value = new AddressDetail();
		value.setAddrDetail(getAddress());
		value.setCityOrTownOrDistrict(getCityOrTownOrDistrict());
		value.setPinCode(getPincode());
		value.setStateCode(getState());
		doneeWithPan.setAddressDetail(value);
		return doneeWithPan;
	}

	
	
	@Override
	public void updateModelProperties(){
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GGAController1.type.relevantClauseUndrDedClaimed", getType());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GGAController1.type.nameOfDonee", getDoneeName());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GGAController1.type.addressDetail.addrDetail", getAddress());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GGAController1.type.addressDetail.cityOrTownOrDistrict", getCityOrTownOrDistrict());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GGAController1.type.addressDetail.stateCode", getState());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GGAController1.type.addressDetail.pinCode", getPincode());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GGAController1.type.doneePAN", getDoneePAN());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GGAController1.type.donationAmtOtherMode", getDonationAmtOtherMode());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GGAController1.type.donationAmtCash", getDonationAmtCash());
		donationAmt = OnChangeUtil.getElementValueByTargetNameBig("itr1_80GGAController1.type.donationAmt");
		eligibleDonationAmt = OnChangeUtil.getElementValueByTargetNameBig("itr1_80GGAController1.type.eligibleDonationAmt");
		
		List<DonationDtlsSciRsrchRuralDev> list = ((TableViewController)ValidationUtil.ALL_TVC.get("class com.itd.efiling.offline.ITR1.ctrl.ITR1_80GGATable1")).getTableView().getItems();

		List<DonationDtlsSciRsrchRuralDev> donationDtlsSciRsrchRuralDevList = schedule80GGA.getDonationDtlsSciRsrchRuralDev();
		if(donationDtlsSciRsrchRuralDevList == null){
			donationDtlsSciRsrchRuralDevList = new ArrayList<>();
			schedule80GGA.setDonationDtlsSciRsrchRuralDev(donationDtlsSciRsrchRuralDevList);
		}

		DonationDtlsSciRsrchRuralDev obj =  getDonationDtlsSciRsrchRuralDev();
		list.add(obj);
		donationDtlsSciRsrchRuralDevList.add(obj);

		GenerateXMLUtility.setElementValueByTargetName("itr1_80GGAController1.type.donationAmtOtherMode", getDonationAmtOtherMode());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GGAController1.type.donationAmtCash", getDonationAmtCash());

		updateOnChangedProperty("itr1_80GGAController1.type.donationAmtOtherMode", getDonationAmtOtherMode());
		updateOnChangedProperty("itr1_80GGAController1.type.donationAmtCash", getDonationAmtCash());
		
		updateOnChangedProperty("itr1_80GGAController1.type.donationAmt", donationAmt.toString());
		updateOnChangedProperty("itr1_80GGAController1.type.eligibleDonationAmt", eligibleDonationAmt.toString());


	}
	
	public String getDoneeName() {
		return doneeName;
	}

	public void setDoneeName(String doneeName) {
		this.doneeName = doneeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCityOrTownOrDistrict() {
		return cityOrTownOrDistrict;
	}

	public void setCityOrTownOrDistrict(String cityOrTownOrDistrict) {
		this.cityOrTownOrDistrict = cityOrTownOrDistrict;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDoneePAN() {
		return doneePAN;
	}

	public void setDoneePAN(String doneePAN) {
		this.doneePAN = doneePAN;
	}

	public String getDonationAmtCash() {
		return donationAmtCash == null || donationAmtCash.isEmpty()?"0":donationAmtCash;
	}

	public void setDonationAmtCash(String donationAmtCash) {
		this.donationAmtCash = donationAmtCash;
	}

	public String getDonationAmtOtherMode() {
		return donationAmtOtherMode == null || donationAmtOtherMode.isEmpty()?"0":donationAmtOtherMode;
	}

	public void setDonationAmtOtherMode(String donationAmtOtherMode) {
		this.donationAmtOtherMode = donationAmtOtherMode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}


	@JsonProperty(value="doneeName")
	String doneeName;

	@JsonProperty(value="address")
	String address;

	@JsonProperty(value="cityOrTownOrDistrict")
	String cityOrTownOrDistrict;

	@JsonProperty(value="state")
	String state;

	@JsonProperty(value="pincode")
	String pincode;

	@JsonProperty(value="doneePAN")
	String doneePAN;

	@JsonProperty(value="donationAmtCash")
	String donationAmtCash;

	@JsonProperty(value="donationAmtOtherMode")
	String donationAmtOtherMode;

	@JsonProperty(value="type")
	String type;

	@JsonProperty(value="required")
	boolean required=false;
}
