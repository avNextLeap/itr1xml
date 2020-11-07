package com.nextleap.itr.generatexml.itr1.model.donation80G;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.itd.efiling.offline.ITR1.model.AddressDetail;
import com.itd.efiling.offline.ITR1.model.Don100Percent;
import com.itd.efiling.offline.ITR1.model.DoneeWithPan;
import com.itd.efiling.offline.ITR1.model.Schedule80G;
import com.itd.efiling.offline.ITR1.onchange.util.OnChangeUtil;
import com.itd.efiling.offline.common.validation.validators.ValidationUtil;
import com.itd.efiling.offline.javafx.ui.components.TableViewController;
import com.nextleap.itr.generatexml.GenerateXMLUtility;

public class Donation80G1 extends Datanation80GDataObject{

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
		
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GController1.type.doneeWithPanName", getDoneeName());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GController1.type.addressDetail.addrDetail", getAddress());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GController1.type.addressDetail.cityOrTownOrDistrict", getCityOrTownOrDistrict());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GController1.type.addressDetail.stateCode", getState());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GController1.type.addressDetail.pinCode", getPincode());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GController1.type.doneePAN", getDoneePAN());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GController1.type.donationAmtOtherMode", getDonationAmtOtherMode());
		GenerateXMLUtility.setElementValueByTargetName("itr1_80GController1.type.donationAmtCash", getDonationAmtCash());
		donationAmt = OnChangeUtil.getElementValueByTargetNameBig("itr1_80GController1.type.donationAmt");
		eligibleDonationAmt = OnChangeUtil.getElementValueByTargetNameBig("itr1_80GController1.type.eligibleDonationAmt");
		
		List<DoneeWithPan> list = ((TableViewController)ValidationUtil.ALL_TVC.get("class com.itd.efiling.offline.ITR1.ctrl.ITR1_80GTable1")).getTableView().getItems();

		Don100Percent don100Percent = schedule80G.getDon100Percent();
		if(don100Percent == null){
			don100Percent = new Don100Percent();
			schedule80G.setDon100Percent(don100Percent);
		}

		List<DoneeWithPan> details = don100Percent.getDoneeWithPan();
		if(details == null){
			details = new ArrayList<DoneeWithPan>();
			don100Percent.setDoneeWithPan(details);
		}
		DoneeWithPan obj =  getDoneeWithPan();
		list.add(obj);
		details.add(obj);
		
		updateOnChangedProperty("itr1_80GController1.type.donationAmtOtherMode", getDonationAmtOtherMode());
		updateOnChangedProperty("itr1_80GController1.type.donationAmtCash", getDonationAmtCash());

		updateOnChangedProperty("itr1_80GController1.type.donationAmt", donationAmt.toString());
		updateOnChangedProperty("itr1_80GController1.type.eligibleDonationAmt", eligibleDonationAmt.toString());

	}
}
