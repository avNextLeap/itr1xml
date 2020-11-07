package com.nextleap.itr.generatexml.itr1.model.incomededuction.houseproperty;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class House {

	@JsonProperty(value="arrearsRent")
	private String arrearsRent="0";

	@JsonProperty(value="interestPayable")
	private String interestPaybale="0";

	@JsonProperty(value="preConstructionInterest")
	private String preConstructionInterest="0";


	public String getPreConstructionInterest() {
		return preConstructionInterest;
	}

	public void setPreConstructionInterest(String preConstructionInterest) {
		this.preConstructionInterest = preConstructionInterest;
	}


	public String getArrearsRent() {
		if(arrearsRent == null || arrearsRent.isEmpty()){
			return "0";
		}
		BigInteger arrearsRentInt = new BigInteger(this.arrearsRent);
		if(arrearsRentInt.compareTo(new BigInteger("0")) == 1){
			arrearsRent  = arrearsRentInt.subtract(arrearsRentInt.multiply(new BigInteger("30")).divide(new BigInteger("100"))).toString();
		}
		
		return arrearsRent;
	}

	public void setArrearsRent(String arrearsRent) {
		this.arrearsRent = arrearsRent;
	}

	public String getInterestPaybale() {
		if(this.interestPaybale == null ||  this.interestPaybale.isEmpty()){
			this.interestPaybale = "0";
		}
		BigDecimal dataDecimal = new BigDecimal(this.interestPaybale);
		BigInteger interestPayInt = dataDecimal.toBigInteger();
		if(getPreConstructionInterest() == null || getPreConstructionInterest().isEmpty()){
			return interestPayInt.toString();
		}
		BigDecimal preConstIntDecimal = new BigDecimal(getPreConstructionInterest());
		BigInteger preConstInt = preConstIntDecimal.toBigInteger();
		if(preConstInt.compareTo(new BigInteger("0")) == 1){
			BigInteger actualPreConstInst = preConstInt.multiply(BigInteger.valueOf(20)).divide(BigInteger.valueOf(100));
			interestPayInt = interestPayInt.add(actualPreConstInst);
		}
		return interestPayInt.toString();
	}

	public void setInterestPaybale(String interestPaybale) {
		this.interestPaybale = interestPaybale;
	}

}
