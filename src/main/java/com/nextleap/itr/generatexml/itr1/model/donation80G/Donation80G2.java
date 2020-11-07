package com.nextleap.itr.generatexml.itr1.model.donation80G;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.itd.efiling.offline.ITR1.model.AddressDetail;
import com.itd.efiling.offline.ITR1.model.Don50PercentNoApprReqd;
import com.itd.efiling.offline.ITR1.model.DoneeWithPan;
import com.itd.efiling.offline.ITR1.model.Schedule80G;
import com.itd.efiling.offline.ITR1.onchange.util.OnChangeUtil;
import com.itd.efiling.offline.common.validation.validators.ValidationUtil;
import com.itd.efiling.offline.javafx.ui.components.TableViewController;
import com.nextleap.itr.generatexml.GenerateXMLUtility;

public class Donation80G2 extends Datanation80GDataObject{

	BigInteger donationAmt;
	BigInteger eligibleDonationAmt;
	
	Schedule80G schedule80G;
	
	public Schedule80G getSchedule80G() {
		return schedule80G;
	}

	public void setSchedule80G(Schedule80G schedule80g) {
		schedule80G = schedule80g;
	}

	
	private DoneeWithPan getDoneeWithPan(){
		DoneeWithPan doneeWithPan = new DoneeWithPan();
		BigInteger amountCash = new BigInteger(getDonationAmtCash());
		doneeWithPan.setDonationAmtCash(amountCash);
		BigInteger donationAmtOtherMode = new BigInteger(getDonationAmtOtherMode());
		doneeWithPan.setDonationAmtOtherMode(donationAmtOtherMode);
		doneeWithPan.setDonationAmt(donationAmt);
		doneeWithPan.setEligibleDonationAmt(eligibleDonationAmt);
		doneeWithPan.setDoneePAN(getDoneePAN());
		doneeWithPan.setDoneeWithPanName(getDoneeName());
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
		
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GController2.type.doneeWithPanName", getDoneeName());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GController2.type.addressDetail.addrDetail", getAddress());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GController2.type.addressDetail.cityOrTownOrDistrict", getCityOrTownOrDistrict());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GController2.type.addressDetail.stateCode", getState());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GController2.type.addressDetail.pinCode", getPincode());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GController2.type.doneePAN", getDoneePAN());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GController2.type.donationAmtOtherMode", getDonationAmtOtherMode());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GController2.type.donationAmtCash", getDonationAmtCash());
		donationAmt = OnChangeUtil.getElementValueByTargetNameBig("itr1_80GController2.type.donationAmt");
		eligibleDonationAmt = OnChangeUtil.getElementValueByTargetNameBig("itr1_80GController2.type.eligibleDonationAmt");
		
		List<DoneeWithPan> list = ((TableViewController)ValidationUtil.ALL_TVC.get("class com.itd.efiling.offline.ITR1.ctrl.ITR1_80GTable2")).getTableView().getItems();

		Don50PercentNoApprReqd don50PercentNoApprReqd = schedule80G.getDon50PercentNoApprReqd();
		if(don50PercentNoApprReqd == null){
			don50PercentNoApprReqd = new Don50PercentNoApprReqd();
			schedule80G.setDon50PercentNoApprReqd(don50PercentNoApprReqd);
		}
		
		List<DoneeWithPan> details = don50PercentNoApprReqd.getDoneeWithPan();
		if(details == null){
			details = new ArrayList<DoneeWithPan>();
			don50PercentNoApprReqd.setDoneeWithPan(details);
		}
		DoneeWithPan obj =  getDoneeWithPan();
		list.add(obj);
		details.add(obj);
		
		updateOnChangedProperty("itr1_80GController2.type.donationAmtOtherMode", getDonationAmtOtherMode());
		updateOnChangedProperty("itr1_80GController2.type.donationAmtCash", getDonationAmtCash());

		updateOnChangedProperty("itr1_80GController2.type.donationAmt", donationAmt.toString());
		updateOnChangedProperty("itr1_80GController2.type.eligibleDonationAmt", eligibleDonationAmt.toString());

	}
}
