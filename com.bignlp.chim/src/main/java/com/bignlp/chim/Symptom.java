package com.bignlp.chim;

import java.util.Map;

public class Symptom {
	private String name;
	private Map<String, Diagnosis> diagnosisNameVsDiagnosisMap;
	private Map<String, Disease> diseaseNameVsDiseaseMap;

	public Symptom() {
		super();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String argName) {
		this.name = argName;
	}

}
