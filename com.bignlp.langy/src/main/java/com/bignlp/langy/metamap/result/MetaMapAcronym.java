package com.bignlp.langy.metamap.result;

import java.util.List;

import com.bignlp.langy.metamap.AcronymsAbbrevs;

public class MetaMapAcronym {
	private String abbreviation;
	private String expansion;
	private List<String> cuis;
	private List<Integer> counts;

	public MetaMapAcronym() {
		super();
	}

	public MetaMapAcronym(String argsAbbreviation, String argsExpansion,
			List<String> argsCuis, List<Integer> argsCounts) {
		super();
		this.abbreviation = argsAbbreviation;
		this.expansion = argsExpansion;
		this.cuis = argsCuis;
		this.counts = argsCounts;
	}

	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String argsAbbreviation) {
		this.abbreviation = argsAbbreviation;
	}

	public String getExpansion() {
		return this.expansion;
	}

	public void setExpansion(String argsExpansion) {
		this.expansion = argsExpansion;
	}

	public List<String> getCuis() {
		return this.cuis;
	}

	public void setCuis(List<String> argsCuis) {
		this.cuis = argsCuis;
	}

	public List<Integer> getCounts() {
		return this.counts;
	}

	public void setCounts(List<Integer> argsCounts) {
		this.counts = argsCounts;
	}

}
