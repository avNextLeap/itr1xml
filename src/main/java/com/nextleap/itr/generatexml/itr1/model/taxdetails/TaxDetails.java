package com.nextleap.itr.generatexml.itr1.model.taxdetails;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itd.efiling.offline.ITR1.model.ScheduleTDS3Dtls;
import com.itd.efiling.offline.ITR1.model.TDSonOthThanSals;
import com.itd.efiling.offline.ITR1.model.TDSonSalaries;
import com.itd.efiling.offline.ITR1.model.TaxPayments;

public class TaxDetails {

	
	@JsonProperty(value="tds1")
	private List<TDS1> tds1 = Collections.emptyList();

	@JsonProperty(value="tds2")
	private List<TDS2> tds2=Collections.emptyList();

	
	@JsonProperty(value="tds3")
	private List<TDS3> tds3=Collections.emptyList();

	@JsonProperty(value="AdvanceTaxAndSelfAssesmentTax")
	private List<AdvanceTaxAndSelfAssesmentTax> advanceTaxAndSelfAssesmentTax=Collections.emptyList();
	
	
	
	
	public List<AdvanceTaxAndSelfAssesmentTax> getAdvanceTaxAndSelfAssesmentTax() {
		return advanceTaxAndSelfAssesmentTax;
	}

	public void setAdvanceTaxAndSelfAssesmentTax(List<AdvanceTaxAndSelfAssesmentTax> advanceTaxAndSelfAssesmentTax) {
		this.advanceTaxAndSelfAssesmentTax = advanceTaxAndSelfAssesmentTax;
	}

	public List<TDS2> getTds2() {
		return tds2;
	}

	public void setTds2(List<TDS2> tds2) {
		this.tds2 = tds2;
	}

	public List<TDS3> getTds3() {
		return tds3;
	}

	public void setTds3(List<TDS3> tds3) {
		this.tds3 = tds3;
	}


	public List<TDS1> getTds1() {
		return tds1;
	}

	public void setTds1(List<TDS1> tds1) {
		this.tds1 = tds1;
	}
	
	public void updateProperties(TDSonSalaries tDSonSalaries, TDSonOthThanSals tdsonOthThanSals,ScheduleTDS3Dtls scheduleTDS3Dtls,TaxPayments taxPayments){
		for(TDS1 tds1 : getTds1()){
			if(!tds1.isRequired()){
				continue;
			}
			tds1.updateProperties(tDSonSalaries);
			tds1.updateModelPropertiesForDataObject();	
		}
		for(TDS2 tds2 : getTds2()){
			if(!tds2.isRequired()){
				continue;
			}

			tds2.updateProperties(tdsonOthThanSals);
			tds2.updateModelPropertiesForDataObject();	
		}

		for(TDS3 tds3 : getTds3()){
			if(!tds3.isRequired()){
				continue;
			}

			tds3.updateProperties(scheduleTDS3Dtls);
			tds3.updateModelPropertiesForDataObject();	
		}

		for(AdvanceTaxAndSelfAssesmentTax tax :getAdvanceTaxAndSelfAssesmentTax()){
			if(!tax.isRequired()){
				continue;
			}
			tax.updateProperties(taxPayments);
			tax.updateModelPropertiesForDataObject();
		}
	}
}
