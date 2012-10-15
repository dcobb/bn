package com.bignlp.langy.wsd;

public class ArbitratorRecord {
	private String disambiguationMethodName;
	private String preferredConceptName;
	private double weight;

	public ArbitratorRecord() {
		super();
	}

	public ArbitratorRecord(String argDisambiguationMethodName,
			String argPreferredConceptName, double argWeight) {
		super();
		this.disambiguationMethodName = argDisambiguationMethodName;
		this.preferredConceptName = argPreferredConceptName;
		this.weight = argWeight;
	}

	public String getDisambiguationMethodName() {
		return this.disambiguationMethodName;
	}

	public void setDisambiguationMethodName(String argDisambiguationMethodName) {
		this.disambiguationMethodName = argDisambiguationMethodName;
	}

	public String getPreferredConceptName() {
		return this.preferredConceptName;
	}

	public void setPreferredConceptName(String argPreferredConceptName) {
		this.preferredConceptName = argPreferredConceptName;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double argWeight) {
		this.weight = argWeight;
	}

}
