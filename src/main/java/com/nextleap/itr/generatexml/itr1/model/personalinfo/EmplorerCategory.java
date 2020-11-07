package com.nextleap.itr.generatexml.itr1.model.personalinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmplorerCategory {

	EmplorerCategoryType category = EmplorerCategoryType.NA;

	public EmplorerCategoryType getCategory() {
		return category;
	}

	public void setCategory(EmplorerCategoryType category) {
		this.category = category;
	}
	
	
}
