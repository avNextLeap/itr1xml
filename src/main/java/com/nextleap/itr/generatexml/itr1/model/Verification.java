package com.nextleap.itr.generatexml.itr1.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itd.efiling.offline.ITR1.model.BankAccountDtls;
import com.itd.efiling.offline.ITR1.model.BankDetailType;
import com.itd.efiling.offline.common.onchange.util.OnChangeCommonUtil;
import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.incomededuction.BankDetails;

public class Verification extends DataObject {

	@Override
	public void updateModelProperties(){
	
	}

	public void updateModelProperties(BankAccountDtls bnkDetails){
		List<BankDetailType> bdtypeList  = bnkDetails.getAddtnlBankDetails();
		
		for(BankDetails bkd : getOtherBankDetails()){
			GenerateXMLUtility.setElementValueByTargetName("incomeDetailsController.type.bankName",bkd.getBankName());
			GenerateXMLUtility.setElementValueByTargetName("incomeDetailsController.type.bankAccountNo",bkd.getBankAccountNo());
			GenerateXMLUtility.setElementValueByTargetName("incomeDetailsController.type.checkBoxFlag",bkd.isUsedForRefund().toString());
			GenerateXMLUtility.setElementValueByTargetName("incomeDetailsController.type.ifscCode",bkd.getBankIfscCode());
			
			
			BankDetailType type = new BankDetailType();
			type.setBankAccountNo(bkd.getBankAccountNo());
			type.setBankName(bkd.getBankName());
			type.setIfscCode(bkd.getBankIfscCode());
			type.setCheckBoxFlag(Boolean.parseBoolean(OnChangeCommonUtil.getElementValueByTargetName("incomeDetailsController.type.checkBoxFlag").toString()));
			type.setCheckBoxHidValue(OnChangeCommonUtil.getElementValueByTargetName("incomeDetailsController.type.checkBoxHidValue").toString());
			type.setCheckBoxValue(OnChangeCommonUtil.getElementValueByTargetName("incomeDetailsController.type.checkBoxValue").toString());
			if(bdtypeList == null){
				bdtypeList = new ArrayList<>();
			}
			bdtypeList.add(type);
		}
		
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.verification.declaration.assesseeVerName",getAssesseeVerName());
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.verification.declaration.fatherName",getFatherName());
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.verification.capacity",getCapacity());
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.verification.declaration.assesseeVerPAN",getAssesseeVerPAN());
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.verification.place",getPlace());
		
	}


	public List<BankDetails> getOtherBankDetails() {
		return otherBankDetails;
	}

	public void setOtherBankDetails(List<BankDetails> otherBankDetails) {
		this.otherBankDetails = otherBankDetails;
	}

	public String getAssesseeVerName() {
		return assesseeVerName;
	}

	public void setAssesseeVerName(String assesseeVerName) {
		this.assesseeVerName = assesseeVerName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getAssesseeVerPAN() {
		return assesseeVerPAN;
	}

	public void setAssesseeVerPAN(String assesseeVerPAN) {
		this.assesseeVerPAN = assesseeVerPAN;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	
	@JsonProperty(value="bankDetails")
	List<BankDetails> otherBankDetails = Collections.emptyList();

	@JsonProperty(value="assesseeVerName")
	String assesseeVerName;

	@JsonProperty(value="fatherName")
	String fatherName;

	@JsonProperty(value="capacity")
	String capacity="S";

	@JsonProperty(value="assesseeVerPAN")
	String assesseeVerPAN;

	@JsonProperty(value="place")
	String place;
	
}
