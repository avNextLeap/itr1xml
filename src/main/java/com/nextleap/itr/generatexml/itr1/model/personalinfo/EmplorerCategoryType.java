package com.nextleap.itr.generatexml.itr1.model.personalinfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum EmplorerCategoryType {

	CGOV,
	SGOV,
	PSU,
	PE,
    OTH,
    NA;
    
    @JsonCreator
    public EmplorerCategoryType createEmplorerCategory(@JsonProperty("category") String category,@JsonProperty("doc") String doc){
		for(EmplorerCategoryType cat:EmplorerCategoryType.values()){
			if(cat.name().equals(category)){
				return cat;
			}
		}
		return EmplorerCategoryType.NA;
	}
    
}
