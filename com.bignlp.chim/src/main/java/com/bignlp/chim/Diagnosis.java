package com.bignlp.chim;

import java.util.Map;

public class Diagnosis {
	private String name;
	private Map<String, Symptom> symptomNameVsSymptomMap;

	public Diagnosis() {
		super();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String argName) {
		this.name = argName;
	}

}
