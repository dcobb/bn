package com.bignlp.chim;

import java.util.Map;

public class Drug {
	private String name;
	private String routeOfAministration;
	private Map<String, Disease> diseaseNameVsDiseaseMap;

	public Drug() {
		super();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String argName) {
		this.name = argName;
	}

}
