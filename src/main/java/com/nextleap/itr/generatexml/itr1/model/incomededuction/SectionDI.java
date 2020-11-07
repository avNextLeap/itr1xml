package com.nextleap.itr.generatexml.itr1.model.incomededuction;

import java.math.BigInteger;

import com.itd.efiling.offline.common.onchange.util.OnChangeCommonUtil;
import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.DataObject;

public class SectionDI  extends DataObject{

	
	@Override
	public void updateModelProperties() {
		
		if(getApplicable() == null || getApplicable().isEmpty() || getApplicable().equalsIgnoreCase("no") || getApplicable().equalsIgnoreCase("n")){
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.depPayInvClmUndDednVIA", "N");	
			return;
		}
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.depPayInvClmUndDednVIA", "Y");
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.scheduleDI.invstDpstPymntDtlUsr.section80C", 
				getCurrentDeductionValue("itr.itr1.scheduleDI.invstDpstPymntDtlSysCalc.section80C").min(new BigInteger(getSection80C())).toString());
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.scheduleDI.invstDpstPymntDtlUsr.section80CCC", 
				getCurrentDeductionValue("itr.itr1.scheduleDI.invstDpstPymntDtlSysCalc.section80CCC").min(new BigInteger(getSection80CCC())).toString());
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.scheduleDI.invstDpstPymntDtlUsr.section80CCDEmployeeOrSE", 
				getCurrentDeductionValue("itr.itr1.scheduleDI.invstDpstPymntDtlSysCalc.section80CCDEmployeeOrSE").min(new BigInteger(getSection80CCD())).toString());
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.scheduleDI.invstDpstPymntDtlUsr.section80CCD1B", 
				getCurrentDeductionValue("itr.itr1.scheduleDI.invstDpstPymntDtlSysCalc.section80CCD1B").min(new BigInteger(getSection80CCD1B())).toString());
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.scheduleDI.invstDpstPymntDtlUsr.section80CCDEmployer", 
				getCurrentDeductionValue("itr.itr1.scheduleDI.invstDpstPymntDtlSysCalc.section80CCDEmployer").min(new BigInteger(getSection80CCD2())).toString());
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.scheduleDI.invstDpstPymntDtlUsr.section80D", 
				getCurrentDeductionValue("itr.itr1.scheduleDI.invstDpstPymntDtlSysCalc.section80D").min(new BigInteger(getSection80D())).toString());
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.scheduleDI.invstDpstPymntDtlUsr.section80DD", 
				getCurrentDeductionValue("itr.itr1.scheduleDI.invstDpstPymntDtlSysCalc.section80DD").min(new BigInteger(getSection80DD())).toString());
		
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.scheduleDI.invstDpstPymntDtlUsr.section80DDB", 
				getCurrentDeductionValue("itr.itr1.scheduleDI.invstDpstPymntDtlSysCalc.section80DDB").min(new BigInteger(getSection80DDB())).toString());

		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.scheduleDI.invstDpstPymntDtlUsr.section80E", 
				getCurrentDeductionValue("itr.itr1.scheduleDI.invstDpstPymntDtlSysCalc.section80E").min(new BigInteger(getSection80E())).toString());
		
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.scheduleDI.invstDpstPymntDtlUsr.section80EE", 
				getCurrentDeductionValue("itr.itr1.scheduleDI.invstDpstPymntDtlSysCalc.section80EE").min(new BigInteger(getSection80EE())).toString());
		
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.scheduleDI.invstDpstPymntDtlUsr.section80EEA", 
				getCurrentDeductionValue("itr.itr1.scheduleDI.invstDpstPymntDtlSysCalc.section80EEA").min(new BigInteger(getSection80EEA())).toString());
		
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.scheduleDI.invstDpstPymntDtlUsr.section80EEB", 
				getCurrentDeductionValue("itr.itr1.scheduleDI.invstDpstPymntDtlSysCalc.section80EEB").min(new BigInteger(getSection80EEB())).toString());
		
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.scheduleDI.invstDpstPymntDtlUsr.section80G", 
				getCurrentDeductionValue("itr.itr1.scheduleDI.invstDpstPymntDtlSysCalc.section80G").min(new BigInteger(getSection80G())).toString());
		
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.scheduleDI.invstDpstPymntDtlUsr.section80GG", 
				getCurrentDeductionValue("itr.itr1.scheduleDI.invstDpstPymntDtlSysCalc.section80GG").min(new BigInteger(getSection80GG())).toString());
		
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.scheduleDI.invstDpstPymntDtlUsr.section80GGA", 
				getCurrentDeductionValue("itr.itr1.scheduleDI.invstDpstPymntDtlSysCalc.section80GGA").min(new BigInteger(getSection80GGA())).toString());
		
		GenerateXMLUtility.setElementValueByTargetName("itr.itr1.scheduleDI.invstDpstPymntDtlUsr.section80GGC", 
				getCurrentDeductionValue("itr.itr1.scheduleDI.invstDpstPymntDtlSysCalc.section80GGC").min(new BigInteger(getSection80GGC())).toString());
	}
	
	private BigInteger getCurrentDeductionValue(String key){
		BigInteger value = (BigInteger)OnChangeCommonUtil.getElementValueByTargetName(key);
		if(value == null){
			value = new BigInteger("0");
		}
		return value;
	}

	
	public String getApplicable() {
		return applicable;
	}
	public void setApplicable(String applicable) {
		this.applicable = applicable;
	}
	public String getSection80C() {
		return section80C;
	}
	public void setSection80C(String section80c) {
		section80C = section80c;
	}
	public String getSection80CCC() {
		return section80CCC;
	}
	public void setSection80CCC(String section80ccc) {
		section80CCC = section80ccc;
	}
	public String getSection80CCD() {
		return section80CCD;
	}
	public void setSection80CCD(String section80ccd) {
		section80CCD = section80ccd;
	}
	public String getSection80CCD1B() {
		return section80CCD1B;
	}
	public void setSection80CCD1B(String section80ccd1b) {
		section80CCD1B = section80ccd1b;
	}
	public String getSection80CCD2() {
		return section80CCD2;
	}
	public void setSection80CCD2(String section80ccd2) {
		section80CCD2 = section80ccd2;
	}
	public String getSection80D() {
		return section80D;
	}
	public void setSection80D(String section80d) {
		section80D = section80d;
	}
	public String getSection80DD() {
		return section80DD;
	}
	public void setSection80DD(String section80dd) {
		section80DD = section80dd;
	}
	public String getSection80DDB() {
		return section80DDB;
	}
	public void setSection80DDB(String section80ddb) {
		section80DDB = section80ddb;
	}
	public String getSection80E() {
		return section80E;
	}
	public void setSection80E(String section80e) {
		section80E = section80e;
	}
	public String getSection80EE() {
		return section80EE;
	}
	public void setSection80EE(String section80ee) {
		section80EE = section80ee;
	}
	public String getSection80EEA() {
		return section80EEA;
	}
	public void setSection80EEA(String section80eea) {
		section80EEA = section80eea;
	}
	public String getSection80EEB() {
		return section80EEB;
	}
	public void setSection80EEB(String section80eeb) {
		section80EEB = section80eeb;
	}
	public String getSection80G() {
		return section80G;
	}
	public void setSection80G(String section80g) {
		section80G = section80g;
	}
	public String getSection80GG() {
		return section80GG;
	}
	public void setSection80GG(String section80gg) {
		section80GG = section80gg;
	}
	public String getSection80GGA() {
		return section80GGA;
	}
	public void setSection80GGA(String section80gga) {
		section80GGA = section80gga;
	}
	public String getSection80GGC() {
		return section80GGC;
	}
	public void setSection80GGC(String section80ggc) {
		section80GGC = section80ggc;
	}
	public String applicable="no";
	public String section80C="0";
	public String section80CCC="0";
	public String section80CCD="0";
	public String section80CCD1B="0";
	public String section80CCD2="0";
	public String section80D="0";
	public String section80DD="0";
	public String section80DDB="0";
	public String section80E="0";
	public String section80EE="0";
	public String section80EEA="0";
	public String section80EEB="0";
	public String section80G="0";
	public String section80GG="0";
	public String section80GGA="0";
	public String section80GGC="0";
	
}
