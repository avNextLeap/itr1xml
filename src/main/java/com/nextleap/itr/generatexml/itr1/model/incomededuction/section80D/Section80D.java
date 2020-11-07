package com.nextleap.itr.generatexml.itr1.model.incomededuction.section80D;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextleap.itr.generatexml.itr1.model.DataObject;

public class Section80D extends DataObject{

	@JsonProperty(value="selfAndFamilyExcludingParentAsSeniorCtz")
	private SelfAndFamilyExcludingParentAsSeniorCtz selfAndFamilyExcludingParentAsSeniorCtz;
	
	@JsonProperty(value="parentAsSeniorCitizen")
	private ParentAsSeniorCitizen parentAsSeniorCitizen;

	public SelfAndFamilyExcludingParentAsSeniorCtz getSelfAndFamilyExcludingParentAsSeniorCtz() {
		return selfAndFamilyExcludingParentAsSeniorCtz;
	}

	public void setSelfAndFamilyExcludingParentAsSeniorCtz(
			SelfAndFamilyExcludingParentAsSeniorCtz selfAndFamilyExcludingParentAsSeniorCtz) {
		this.selfAndFamilyExcludingParentAsSeniorCtz = selfAndFamilyExcludingParentAsSeniorCtz;
	}

	public ParentAsSeniorCitizen getParentAsSeniorCitizen() {
		return parentAsSeniorCitizen;
	}

	public void setParentAsSeniorCitizen(ParentAsSeniorCitizen parentAsSeniorCitizen) {
		this.parentAsSeniorCitizen = parentAsSeniorCitizen;
	}

	public void updateModelObjectProperties(){
		
		if(selfAndFamilyExcludingParentAsSeniorCtz!=null){
			selfAndFamilyExcludingParentAsSeniorCtz.updateProperties();
		}
		
		if(parentAsSeniorCitizen!=null){
			parentAsSeniorCitizen.updateProperties(selfAndFamilyExcludingParentAsSeniorCtz.getPreventiveHealthCheckUp());
		}
	}

	@Override
	public void updateModelProperties() {
		// TODO Auto-generated method stub
		
	}
	
}
