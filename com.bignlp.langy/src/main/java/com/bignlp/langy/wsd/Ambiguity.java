package com.bignlp.langy.wsd;

import java.util.List;

public class Ambiguity {
	private boolean skipProcessing;
	private List<Candidate> candidates;

	public Ambiguity() {
		super();
	}

	public Ambiguity(boolean argSkipProcessing, List<Candidate> argCandidates) {
		super();
		this.skipProcessing = argSkipProcessing;
		this.candidates = argCandidates;
	}

	public boolean isSkipProcessing() {
		return this.skipProcessing;
	}

	public void setSkipProcessing(boolean argNeedProcessing) {
		this.skipProcessing = argNeedProcessing;
	}

	public List<Candidate> getCandidates() {
		return this.candidates;
	}

	public void setCandidates(List<Candidate> argCandidates) {
		this.candidates = argCandidates;
	}

}
