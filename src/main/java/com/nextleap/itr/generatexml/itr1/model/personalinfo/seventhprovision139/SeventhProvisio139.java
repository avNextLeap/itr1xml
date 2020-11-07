package com.nextleap.itr.generatexml.itr1.model.personalinfo.seventhprovision139;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextleap.itr.generatexml.GenerateXMLUtility;

public class SeventhProvisio139 {
	
	public void updateProperties(){
		
		if("Yes".equalsIgnoreCase(getApplicable())){
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.filingStatus.seventhProvisio139","Y");

			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.filingStatus.depAmtAggAmtExcd1CrPrYrFlg",getDepositedAmtAggAmtExcd1CrPrYr().getApplicable());
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.filingStatus.amtSeventhProvisio139i",getDepositedAmtAggAmtExcd1CrPrYr().getAmount());
			
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.filingStatus.incrExpAggAmt2LkTrvFrgnCntryFlg",getIncurredExpAggAmt2LkTrvFrgnCountry().getApplicable());
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.filingStatus.amtSeventhProvisio139ii",getIncurredExpAggAmt2LkTrvFrgnCountry().getAmount());
			
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.filingStatus.incrExpAggAmt1LkElctrctyPrYrFlg",getIncrExpAggAmt1LkElctrctyPrYr().getApplicable());
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.filingStatus.amtSeventhProvisio139iii",getIncrExpAggAmt1LkElctrctyPrYr().getApplicable());
			
		}else{
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.filingStatus.seventhProvisio139","N");
			//GenerateXMLUtility.setElementValueByTargetName("itr.itr1.filingStatus.depAmtAggAmtExcd1CrPrYrFlg","N");
			//GenerateXMLUtility.setElementValueByTargetName("itr.itr1.filingStatus.incrExpAggAmt2LkTrvFrgnCntryFlg","N");
			//GenerateXMLUtility.setElementValueByTargetName("itr.itr1.filingStatus.incrExpAggAmt1LkElctrctyPrYrFlg","N");


		}
	}
	
	public String getApplicable() {
		return applicable;
	}

	public void setApplicable(String applicable) {
		this.applicable = applicable;
	}

	public DepositedAmtAggAmtExcd1CrPrYr getDepositedAmtAggAmtExcd1CrPrYr() {
		return depositedAmtAggAmtExcd1CrPrYr;
	}

	public void setDepositedAmtAggAmtExcd1CrPrYr(DepositedAmtAggAmtExcd1CrPrYr depositedAmtAggAmtExcd1CrPrYr) {
		this.depositedAmtAggAmtExcd1CrPrYr = depositedAmtAggAmtExcd1CrPrYr;
	}

	public IncurredExpAggAmt2LkTrvFrgnCountry getIncurredExpAggAmt2LkTrvFrgnCountry() {
		return incurredExpAggAmt2LkTrvFrgnCountry;
	}

	public void setIncurredExpAggAmt2LkTrvFrgnCountry(
			IncurredExpAggAmt2LkTrvFrgnCountry incurredExpAggAmt2LkTrvFrgnCountry) {
		this.incurredExpAggAmt2LkTrvFrgnCountry = incurredExpAggAmt2LkTrvFrgnCountry;
	}

	public IncrExpAggAmt1LkElctrctyPrYr getIncrExpAggAmt1LkElctrctyPrYr() {
		return incrExpAggAmt1LkElctrctyPrYr;
	}

	public void setIncrExpAggAmt1LkElctrctyPrYr(IncrExpAggAmt1LkElctrctyPrYr incrExpAggAmt1LkElctrctyPrYr) {
		this.incrExpAggAmt1LkElctrctyPrYr = incrExpAggAmt1LkElctrctyPrYr;
	}

	@JsonProperty(value = "applicable")
	private String applicable="No";

	@JsonProperty(value = "depositedAmtAggAmtExcd1CrPrYr")
	private DepositedAmtAggAmtExcd1CrPrYr depositedAmtAggAmtExcd1CrPrYr;
	
	@JsonProperty(value = "incurredExpAggAmt2LkTrvFrgnCountry")
	private IncurredExpAggAmt2LkTrvFrgnCountry incurredExpAggAmt2LkTrvFrgnCountry;

	@JsonProperty(value = "incrExpAggAmt1LkElctrctyPrYr")
	private IncrExpAggAmt1LkElctrctyPrYr incrExpAggAmt1LkElctrctyPrYr;

	

}
