package com.nextleap.itr.generatexml.itr1.model.incomededuction.section80D;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextleap.itr.generatexml.GenerateXMLUtility;


@JsonIgnoreProperties(ignoreUnknown=true)
public class SelfAndFamilyExcludingParentAsSeniorCtz {
	
	@JsonProperty(value="seniorCitizenFlag")
	String seniorCitizenFlag;
	
	@JsonProperty(value="healthInsurancePremium")
	HealthInsurancePremium healthInsurancePremium;
	
	@JsonProperty(value="medicalExpenditure")
	MedicalExpenditure medicalExpenditure;
	
	@JsonProperty(value="preventiveHealthCheckUp")
	PreventiveHealthCheckUp preventiveHealthCheckUp;
	
   public void updateProperties(){
	   
	   SeniorCitizenFlag flag = SeniorCitizenFlag.getSeniorCitizenFlag(seniorCitizenFlag);
	   
	   if(SeniorCitizenFlag.YES == flag){
		   GenerateXMLUtility.setElementValueByTargetName("itr.itr1.schedule80D.sec80DSelfFamSrCtznHealth.seniorCitizenFlag", "Y");
		   healthInsurancePremium.updateModelProperties("itr.itr1.schedule80D.sec80DSelfFamSrCtznHealth.hlthInsPremSlfFamSrCtzn");
		   medicalExpenditure.updateModelProperties("itr.itr1.schedule80D.sec80DSelfFamSrCtznHealth.medicalExpSlfFamSrCtzn");
		   preventiveHealthCheckUp.updateModelPropertiesForSelfAndFamily("itr.itr1.schedule80D.sec80DSelfFamSrCtznHealth.prevHlthChckUpSlfFamSrCtzn",healthInsurancePremium,true);
	   }

	   if(SeniorCitizenFlag.NO == flag){
		   GenerateXMLUtility.setElementValueByTargetName("itr.itr1.schedule80D.sec80DSelfFamSrCtznHealth.seniorCitizenFlag", "N");
		   healthInsurancePremium.updateModelProperties("itr.itr1.schedule80D.sec80DSelfFamSrCtznHealth.healthInsPremSlfFam");
		   preventiveHealthCheckUp.updateModelPropertiesForSelfAndFamily( "itr.itr1.schedule80D.sec80DSelfFamSrCtznHealth.prevHlthChckUpSlfFam",healthInsurancePremium,false);
	   }

	   if(SeniorCitizenFlag.NOT_CLAIM_SELF_FAMILY == flag){
		   // nothing to updated
		   GenerateXMLUtility.setElementValueByTargetName("itr.itr1.schedule80D.sec80DSelfFamSrCtznHealth.seniorCitizenFlag", "S");
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
