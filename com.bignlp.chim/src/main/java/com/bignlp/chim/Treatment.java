package com.bignlp.chim;

import java.util.Map;

public class Treatment {
	private String name;
	private Map<String, Disease> diseaseNameVsDiseaseMap;

	public Treatment() {
		super();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String argName) {
		this.name = argName;
	}

}
