package com.nextleap.itr.generatexml.itr1.model.donation80G;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextleap.itr.generatexml.itr1.model.DataObject;

public abstract class Datanation80GDataObject extends DataObject{
	
	
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

}
