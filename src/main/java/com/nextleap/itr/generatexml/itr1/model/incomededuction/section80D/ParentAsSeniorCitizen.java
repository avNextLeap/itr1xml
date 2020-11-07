package com.nextleap.itr.generatexml.itr1.model.incomededuction.section80D;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextleap.itr.generatexml.GenerateXMLUtility;


@JsonIgnoreProperties(ignoreUnknown=true)
public class ParentAsSeniorCitizen {
	
	@JsonProperty(value="seniorCitizenFlag")
	String seniorCitizenFlag;
	
	@JsonProperty(value="healthInsurancePremium")
	HealthInsurancePremium healthInsurancePremium;
	
	@JsonProperty(value="medicalExpenditure")
	MedicalExpenditure medicalExpenditure;
	
	@JsonProperty(value="preventiveHealthCheckUp")
	PreventiveHealthCheckUp preventiveHealthCheckUp;
	

	public void updateProperties(PreventiveHealthCheckUp preventiveHealthCheckUpForSelfAndFamily){
		
		   SeniorCitizenFlag flag = SeniorCitizenFlag.getSeniorCitizenFlag(seniorCitizenFlag);
		   
		   if(SeniorCitizenFlag.YES == flag){
			   GenerateXMLUtility.setElementValueByTargetName("itr.itr1.schedule80D.sec80DSelfFamSrCtznHealth.parentsSeniorCitizenFlag", "Y");
			   healthInsurancePremium.updateModelProperties("itr.itr1.schedule80D.sec80DSelfFamSrCtznHealth.hlthInsPremParentsSrCtzn");
			   medicalExpenditure.updateModelProperties("itr.itr1.schedule80D.sec80DSelfFamSrCtznHealth.medicalExpParentsSrCtzn");
			   preventiveHealthCheckUp.updateModelPropertiesForParents("itr.itr1.schedule80D.sec80DSelfFamSrCtznHealth.prevHlthChckUpParentsSrCtzn",preventiveHealthCheckUpForSelfAndFamily.getAmount());
		   }

		   if(SeniorCitizenFlag.NO == flag){
			   GenerateXMLUtility.setElementValueByTargetName("itr.itr1.schedule80D.sec80DSelfFamSrCtznHealth.parentsSeniorCitizenFlag", "N");
			   healthInsurancePremium.updateModelProperties("itr.itr1.schedule80D.sec80DSelfFamSrCtznHealth.hlthInsPremParents");
			   preventiveHealthCheckUp.updateModelPropertiesForParents( "itr.itr1.schedule80D.sec80DSelfFamSrCtznHealth.prevHlthChckUpParents",preventiveHealthCheckUpForSelfAndFamily.getAmount());
		   }

		   if(SeniorCitizenFlag.NO_CLAIM_FOR_PARENTS == flag){
			   // nothing to updated
			   GenerateXMLUtility.setElementValueByTargetName("itr.itr1.schedule80D.sec80DSelfFamSrCtznHealth.parentsSeniorCitizenFlag", "P");
		   }

		
	}
	
	public String getSeniorCitizenFlag() {
		return seniorCitizenFlag;
	}

	public void setSeniorCitizenFlag(String seniorCitizenFlag) {
		this.seniorCitizenFlag = seniorCitizenFlag;
	}

	public HealthInsurancePremium getHealthInsurancePremium() {
		return healthInsurancePremium;
	}

	public void setHealthInsurancePremium(HealthInsurancePremium healthInsurancePremium) {
		this.healthInsurancePremium = healthInsurancePremium;
	}

	public MedicalExpenditure getMedicalExpenditure() {
		return medicalExpenditure;
	}

	public void setMedicalExpenditure(MedicalExpenditure medicalExpenditure) {
		this.medicalExpenditure = medicalExpenditure;
	}

	public PreventiveHealthCheckUp getPreventiveHealthCheckUp() {
		return preventiveHealthCheckUp;
	}

	public void setPreventiveHealthCheckUp(PreventiveHealthCheckUp preventiveHealthCheckUp) {
		this.preventiveHealthCheckUp = preventiveHealthCheckUp;
	}

}
