package com.nextleap.itr.generatexml.itr1.model.incomededuction;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itd.efiling.offline.ITR1.ctrl.ITRView;
import com.itd.efiling.offline.ITR1.model.AllwncExemptUs10Dtls;
import com.itd.efiling.offline.ITR1.model.ITR1IncomeDeductions;
import com.nextleap.itr.generatexml.GenerateXMLUtility;
import com.nextleap.itr.generatexml.itr1.model.incomededuction.houseproperty.HouseProperty;
import com.nextleap.itr.generatexml.itr1.model.incomededuction.section80D.Section80D;
import com.nextleap.itr.generatexml.itr1.model.personalinfo.GeneralInfo;

@JsonIgnoreProperties(ignoreUnknown=true)
public class IncomeDeductions {

	public HouseProperty getHouseProperty() {
		return houseProperty;
	}

	public void setHouseProperty(HouseProperty houseProperty) {
		this.houseProperty = houseProperty;
	}

	public EntertainmentAlw16ii getEntertainmentAlw16ii() {
		return entertainmentAlw16ii;
	}

	public void setEntertainmentAlw16ii(EntertainmentAlw16ii entertainmentAlw16ii) {
		this.entertainmentAlw16ii = entertainmentAlw16ii;
	}

	public DeductionUs57iia getDeductionUs57iia() {
		return deductionUs57iia;
	}

	public void setDeductionUs57iia(DeductionUs57iia deductionUs57iia) {
		this.deductionUs57iia = deductionUs57iia;
	}

	public Section80C getSection80C() {
		return section80C;
	}

	public void setSection80C(Section80C section80c) {
		section80C = section80c;
	}

	public Section80DDB getSection80DDB() {
		return section80DDB;
	}

	public void setSection80DDB(Section80DDB section80ddb) {
		section80DDB = section80ddb;
	}

	public PerquisitesValue getPerquisitesValue() {
		return perquisitesValue;
	}

	public void setPerquisitesValue(PerquisitesValue perquisitesValue) {
		this.perquisitesValue = perquisitesValue;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public Section80CCD getSection80CCD() {
		return section80CCD;
	}

	public void setSection80CCD(Section80CCD section80ccd) {
		section80CCD = section80ccd;
	}

	public Section80DD getSection80DD() {
		return section80DD;
	}

	public void setSection80DD(Section80DD section80dd) {
		section80DD = section80dd;
	}

	public List<AllownceExemptUs10Details> getTotalAllwncExemptUs10() {
		return totalAllwncExemptUs10;
	}

	public void setTotalAllwncExemptUs10(List<AllownceExemptUs10Details> totalAllwncExemptUs10) {
		this.totalAllwncExemptUs10 = totalAllwncExemptUs10;
	}

	public Section80E getSection80E() {
		return section80E;
	}

	public void setSection80E(Section80E section80e) {
		section80E = section80e;
	}

	public ProfitsInSalary getProfitsInSalary() {
		return profitsInSalary;
	}

	public void setProfitsInSalary(ProfitsInSalary profitsInSalary) {
		this.profitsInSalary = profitsInSalary;
	}

	public Section80CCD1B getSection80CCD1B() {
		return section80CCD1B;
	}

	public void setSection80CCD1B(Section80CCD1B section80ccd1b) {
		section80CCD1B = section80ccd1b;
	}

	public List<IncomeOthSrc> getIncomeOthSrcList() {
		return incomeOthSrcList;
	}

	public void setIncomeOthSrcList(List<IncomeOthSrc> incomeOthSrcList) {
		this.incomeOthSrcList = incomeOthSrcList;
	}

	public Section80TTA getSection80TTA() {
		return section80TTA;
	}

	public void setSection80TTA(Section80TTA section80tta) {
		section80TTA = section80tta;
	}

	public DeductionUs16ia getDeductionUs16ia() {
		return deductionUs16ia;
	}

	public void setDeductionUs16ia(DeductionUs16ia deductionUs16ia) {
		this.deductionUs16ia = deductionUs16ia;
	}

	public ProfessionalTaxUs16iii getProfessionalTaxUs16iii() {
		return professionalTaxUs16iii;
	}

	public void setProfessionalTaxUs16iii(ProfessionalTaxUs16iii professionalTaxUs16iii) {
		this.professionalTaxUs16iii = professionalTaxUs16iii;
	}

	public Section80CCC getSection80CCC() {
		return section80CCC;
	}

	public void setSection80CCC(Section80CCC section80ccc) {
		section80CCC = section80ccc;
	}

	public Section80GG getSection80GG() {
		return section80GG;
	}

	public void setSection80GG(Section80GG section80gg) {
		section80GG = section80gg;
	}

	public Section80GGC getSection80GGC() {
		return section80GGC;
	}

	public void setSection80GGC(Section80GGC section80ggc) {
		section80GGC = section80ggc;
	}

	public Section80TTB getSection80TTB() {
		return section80TTB;
	}

	public void setSection80TTB(Section80TTB section80ttb) {
		section80TTB = section80ttb;
	}

	public Section80U getSection80U() {
		return section80U;
	}

	public void setSection80U(Section80U section80u) {
		section80U = section80u;
	}

	public List<ExemptIncAgriOthUs10> getExemptIncAgriOthUs10() {
		return exemptIncAgriOthUs10;
	}

	public void setExemptIncAgriOthUs10(List<ExemptIncAgriOthUs10> exemptIncAgriOthUs10) {
		this.exemptIncAgriOthUs10 = exemptIncAgriOthUs10;
	}

	public Section80EE getSection80EE() {
		return section80EE;
	}

	public void setSection80EE(Section80EE section80ee) {
		section80EE = section80ee;
	}


	public Section80CCD2 getSection80CCD2() {
		return section80CCD2;
	}

	public void setSection80CCD2(Section80CCD2 section80ccd2) {
		section80CCD2 = section80ccd2;
	}

	public Section89 getSection89() {
		return section89;
	}

	public void setSection89(Section89 section89) {
		this.section89 = section89;
	}



	public BasicSalary getBasicsalary() {
		return basicsalary;
	}

	public void setBasicsalary(BasicSalary basicsalary) {
		this.basicsalary = basicsalary;
	}


	public void updateProperties(ITRView itrView,ITR1IncomeDeductions itr1IncmeDedcutionmodel,GeneralInfo generalInfo){

		this.getSalary().updateModelPropertiesForDataObject();
		this.getPerquisitesValue().updateModelPropertiesForDataObject();
		this.getProfitsInSalary().updateModelPropertiesForDataObject();

		List<AllwncExemptUs10Dtls> itr1AllwncExemptUs10DtlsmodelList = new ArrayList<>();
		long totalAllowance = 0;
		for(AllownceExemptUs10Details allownce: getTotalAllwncExemptUs10()){
			if(allownce.isRequired()){
				BigInteger amount = new BigInteger(allownce.getAmount());
				com.itd.efiling.offline.ITR1.model.AllwncExemptUs10Dtls obj = new com.itd.efiling.offline.ITR1.model.AllwncExemptUs10Dtls();
				obj.setSalNatureDesc(allownce.getType());
				obj.setSalOthAmount(amount);
				obj.setSalOthNatOfInc(allownce.getExceptionDescription());
				itr1AllwncExemptUs10DtlsmodelList.add(obj);
				totalAllowance += amount.longValue();
			}
		}
		
		if(itr1AllwncExemptUs10DtlsmodelList.size()>0){
			itr1IncmeDedcutionmodel.getAllwncExemptUs10().getAllwncExemptUs10Dtls().addAll(itr1AllwncExemptUs10DtlsmodelList);
			GenerateXMLUtility.setElementValueByTargetName("itr.itr1.itr1IncomeDeductions.allwncExemptUs10.totalAllwncExemptUs10", new Long(totalAllowance).toString());
		}

		this.getDeductionUs16ia().updateModelProperties();
		this.getEntertainmentAlw16ii().updateModelProperties(generalInfo,getBasicsalary());
		this.getProfessionalTaxUs16iii().updateModelProperties(generalInfo);
		this.getHouseProperty().updateModelPropertiesForDataObject();

		for(IncomeOthSrc incomeOthSrc : getIncomeOthSrcList()){
			incomeOthSrc.updateModelProperties(itrView,itr1IncmeDedcutionmodel);
		}

		this.getDeductionUs57iia().updateModelProperties(getIncomeOthSrcList());

		this.getSection80C().updateModelPropertiesForDataObject();

		this.getSection80CCC().updateModelPropertiesForDataObject();

		this.getSection80CCD().updateModelPropertiesForDataObject();

		this.getSection80CCD1B().updateModelPropertiesForDataObject();

		this.getSection80CCD2().updateModelPropertiesForDataObject();

		this.getSection80D().updateModelObjectProperties();

		this.getSection80DD().updateModelPropertiesForDataObject();

		this.getSection80DDB().updateModelPropertiesForDataObject();

		this.getSection80E().updateModelPropertiesForDataObject();

		this.getSection80EE().updateModelPropertiesForDataObject();

		this.getSection80EEA().updateModelPropertiesForDataObject();

		this.getSection80EEB().updateModelPropertiesForDataObject();

		this.getSection80GG().updateModelPropertiesForDataObject();

		this.getSection80GGC().updateModelPropertiesForDataObject();

		this.getSection80TTA().updateModelProperties(generalInfo,getIncomeOthSrcList());

		this.getSection80TTB().updateModelProperties(generalInfo,getIncomeOthSrcList());

		this.getSection80U().updateModelPropertiesForDataObject();

		if(getExemptIncAgriOthUs10()!=null){
			for(ExemptIncAgriOthUs10 exempt : getExemptIncAgriOthUs10()){
				BigInteger value = new BigInteger(exempt.getAmount());
				if(value.compareTo(new BigInteger("0")) == 0){
					continue;
				}
				exempt.updateModelProperties(itr1IncmeDedcutionmodel);	

			}
		}

		this.getSection89().updateModelPropertiesForDataObject();
		this.getSectionDI().updateModelProperties();

	}


	public Section80D getSection80D() {
		return section80D;
	}

	public void setSection80D(Section80D section80D) {
		this.section80D = section80D;
	}


	public Section80EEA getSection80EEA() {
		return section80EEA;
	}

	public void setSection80EEA(Section80EEA section80eea) {
		section80EEA = section80eea;
	}

	public Section80EEB getSection80EEB() {
		return section80EEB;
	}

	public void setSection80EEB(Section80EEB section80eeb) {
		section80EEB = section80eeb;
	}

	public SectionDI getSectionDI() {
		return sectionDI;
	}

	public void setSectionDI(SectionDI sectionDI) {
		this.sectionDI = sectionDI;
	}


	@JsonProperty(value="section89")
	private Section89 section89 = new Section89();

	@JsonProperty(value="entertainmentAlw16ii")
	private EntertainmentAlw16ii entertainmentAlw16ii = new EntertainmentAlw16ii();

//	@JsonProperty(value="deductionUs57iia")
	private DeductionUs57iia deductionUs57iia = new DeductionUs57iia();

	@JsonProperty(value="section80C")
	private Section80C section80C = new Section80C();

	@JsonProperty(value="section80DDB")
	private Section80DDB section80DDB = new Section80DDB();

	@JsonProperty(value="perquisitesValue")
	private PerquisitesValue perquisitesValue;

	@JsonProperty(value="salary")
	private Salary salary = new Salary();

	@JsonProperty(value="basicsalary")
	private BasicSalary basicsalary = new BasicSalary();

	@JsonProperty(value="section80CCD")
	private Section80CCD section80CCD =  new Section80CCD();

	@JsonProperty(value="section80CCD2")
	private Section80CCD2 section80CCD2 = new Section80CCD2();

	@JsonProperty(value="section80DD")
	private Section80DD section80DD = new Section80DD() ;

	@JsonProperty(value="allwncExemptUs10")
	private List<AllownceExemptUs10Details> totalAllwncExemptUs10=new ArrayList<>();

	@JsonProperty(value="section80E")
	private Section80E section80E = new Section80E();

	@JsonProperty(value="profitsInSalary")
	private ProfitsInSalary profitsInSalary = new ProfitsInSalary();

	@JsonProperty(value="section80CCD1B")
	private Section80CCD1B section80CCD1B = new Section80CCD1B();

	@JsonProperty(value="incomeOthSrc")
	private List<IncomeOthSrc> incomeOthSrcList = Collections.emptyList();

	@JsonProperty(value="Section80D")
	private Section80D section80D = new Section80D();

	//@JsonProperty(value="section80TTA")
	private Section80TTA section80TTA = new Section80TTA();

	//@JsonProperty(value="deductionUs16ia")
	private DeductionUs16ia deductionUs16ia = new DeductionUs16ia();

	@JsonProperty(value="professionalTaxUs16iii")
	private ProfessionalTaxUs16iii professionalTaxUs16iii = new ProfessionalTaxUs16iii();

	@JsonProperty(value="section80CCC")
	private Section80CCC section80CCC = new Section80CCC();

	@JsonProperty(value="section80GG")
	private Section80GG section80GG = new Section80GG();

	@JsonProperty(value="section80GGC")
	private Section80GGC section80GGC = new Section80GGC();

	//@JsonProperty(value="section80TTB")
	private Section80TTB section80TTB = new Section80TTB() ;

	@JsonProperty(value="section80U")
	private Section80U section80U = new Section80U();

	@JsonProperty(value="exemptIncAgriOthUs10")
	private List<ExemptIncAgriOthUs10> exemptIncAgriOthUs10 = Collections.emptyList();

	@JsonProperty(value="houseproperty")
	private HouseProperty houseProperty = new HouseProperty();

	@JsonProperty(value="section80EE")
	private Section80EE section80EE = new Section80EE();

	@JsonProperty(value="section80EEA")
	private Section80EEA section80EEA = new Section80EEA();

	@JsonProperty(value="section80EEB")
	private Section80EEB section80EEB = new Section80EEB();

	@JsonProperty(value="claim_deduction_for_extended_period")
	private SectionDI sectionDI = new SectionDI();


}
