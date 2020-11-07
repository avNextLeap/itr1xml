package com.nextleap.itr.generatexml.itr1.model.donation80G;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itd.efiling.offline.ITR1.model.Schedule80G;

public class Donation80G {

	public void updateProperties(Schedule80G schedule80G){
		for(Donation80G1 g1:getDonation80G1()){
			g1.setSchedule80G(schedule80G);
			g1.updateModelPropertiesForDataObject();
		}

		for(Donation80G2 g2:getDonation80G2()){
			g2.setSchedule80G(schedule80G);
			g2.updateModelPropertiesForDataObject();
		}

		for(Donation80G3 g3:getDonation80G3()){
			g3.setSchedule80G(schedule80G);
			g3.updateModelPropertiesForDataObject();
		}

		for(Donation80G4 g4:getDonation80G4()){
			g4.setSchedule80G(schedule80G);
			g4.updateModelPropertiesForDataObject();
		}
	}
	
	
	public List<Donation80G1> getDonation80G1() {
		return donation80G1;
	}

	public void setDonation80G1(List<Donation80G1> donation80g1) {
		donation80G1 = donation80g1;
	}

	public List<Donation80G2> getDonation80G2() {
		return donation80G2;
	}

	public void setDonation80G2(List<Donation80G2> donation80g2) {
		donation80G2 = donation80g2;
	}

	public List<Donation80G3> getDonation80G3() {
		return donation80G3;
	}

	public void setDonation80G3(List<Donation80G3> donation80g3) {
		donation80G3 = donation80g3;
	}

	public List<Donation80G4> getDonation80G4() {
		return donation80G4;
	}

	public void setDonation80G4(List<Donation80G4> donation80g4) {
		donation80G4 = donation80g4;
	}

	@JsonProperty(value="don100PercentNotQualifyLimit")
	private List<Donation80G1> donation80G1 = Collections.emptyList();
	
	@JsonProperty(value="don50PercentNotQualifyLimit")
	private List<Donation80G2> donation80G2= Collections.emptyList();

	@JsonProperty(value="don100PercentQualifyLimit")
	private List<Donation80G3> donation80G3=Collections.emptyList();

	@JsonProperty(value="don50PercentQualifyLimit")
	private List<Donation80G4> donation80G4=Collections.emptyList();

}
