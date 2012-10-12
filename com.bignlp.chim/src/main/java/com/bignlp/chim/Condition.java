package com.bignlp.chim;

import java.util.Map;

public class Condition {
	private String name;
	private Map<String, Disease> diseaseNameVsDiseaseMap;
	private Map<String, Symptom> symptomNameVsSymptomMap;
	private Map<String, Organ> organNameVsOrganMap;

	public Condition() {
		super();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String argName) {
		this.name = argName;
	}

}
