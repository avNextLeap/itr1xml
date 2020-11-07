package com.nextleap.itr.generatexml.itr1.model.incomededuction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BankDetails {

	public String getBankIfscCode() {
		return bankIfscCode;
	}

	public void setBankIfscCode(String bankIfscCode) {
		this.bankIfscCode = bankIfscCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public Boolean isUsedForRefund() {
		return isUsedForRefund;
	}

	public void setUsedForRefund(Boolean isUsedForRefund) {
		this.isUsedForRefund = isUsedForRefund;
	}

	
	@JsonProperty(value="ifscCode")
	private String bankIfscCode;

	@JsonProperty(value="bankName")
	private String bankName;

	@JsonProperty(value="bankAccountNo")
	private String bankAccountNo;

	@JsonProperty(value="isUsedForRefund")
	private Boolean isUsedForRefund=false;
}
