package com.bignlp.chim;

import java.util.Map;

public class Specialty {
	private String name;
	private Map<String, Disease> diseaseNameVsDiseaseMap;
	private Map<String, Symptom> symptomNameVsSymptomMap;
	private Map<String, Condition> conditionNameVsConditionMap;
	private Map<String, Drug> medicationNameVsMedicationMap;
	private Map<String, Complication> complicationNameVsComplicationMap;
	private Map<String, Treatment> treatmentNameVsTreatmentMap;
	private Map<String, Procedure> procedureNameVsProcedureMap;
	private Map<String, Organ> organNameVsOrganMap;

	public Specialty() {
		super();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String argName) {
		this.name = argName;
	}

}
