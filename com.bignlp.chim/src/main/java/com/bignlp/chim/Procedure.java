package com.bignlp.chim;

import java.util.Map;

public class Procedure {
	private String name;
	private Map<String, Organ> organNameVsOrganMap;
	private Map<String, Disease> diseaseNameVsDiseaseMap;

	public Procedure() {
		super();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String argName) {
		this.name = argName;
	}

}
