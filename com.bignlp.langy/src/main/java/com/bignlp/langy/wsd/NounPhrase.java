package com.bignlp.langy.wsd;

import java.util.List;

public class NounPhrase {
	private int position;
	private String phrase;
	private List<Candidate> candidates;
	private List<Mapping> mappings;
	private List<Ambiguity> ambiguities;

	public NounPhrase() {
		super();
	}

	public NounPhrase(int argPos, String argPhrase,
			List<Candidate> argCandidates, List<Mapping> argMappings,
			List<Ambiguity> argAmbiguities) {
		super();
		this.position = argPos;
		this.phrase = argPhrase;
		this.candidates = argCandidates;
		this.mappings = argMappings;
		this.ambiguities = argAmbiguities;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int argPos) {
		this.position = argPos;
	}

	public String getPhrase() {
		return this.phrase;
	}

	public void setPhrase(String argPhrase) {
		this.phrase = argPhrase;
	}

	public List<Candidate> getCandidates() {
		return this.candidates;
	}

	public void setCandidates(List<Candidate> argCandidates) {
		this.candidates = argCandidates;
	}

	public List<Mapping> getMappings() {
		return this.mappings;
	}

	public void setMappings(List<Mapping> argMappings) {
		this.mappings = argMappings;
	}

	public List<Ambiguity> getAmbiguities() {
		return this.ambiguities;
	}

	public void setAmbiguities(List<Ambiguity> argAmbiguities) {
		this.ambiguities = argAmbiguities;
	}

}
