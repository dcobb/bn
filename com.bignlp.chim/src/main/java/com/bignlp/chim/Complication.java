package com.bignlp.chim;

import java.util.Map;

public class Complication {
	private String name;
	private Map<String, Disease> diseaseNameVsDiseaseMap;
	private Map<String, Symptom> symptomNameVsSymptomMap;

	public Complication() {
		super();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String argName) {
		this.name = argName;
	}

}
