package com.nextleap.itr.bean;

import com.fasterxml.jackson.databind.JsonNode;

public interface Limits {

	public <T> T getLimit(JsonNode section , String key);
}
