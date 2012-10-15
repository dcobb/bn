package com.bignlp.langy.wsd;

import java.util.List;

public class Mapping {
	private int score;
	private List<Candidate> candidates;

	public Mapping() {
		super();
	}

	public Mapping(int argScore, List<Candidate> argCandidates) {
		super();
		this.score = argScore;
		this.candidates = argCandidates;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int argScore) {
		this.score = argScore;
	}

	public List<Candidate> getCandidates() {
		return this.candidates;
	}

	public void setCandidates(List<Candidate> argCandidates) {
		this.candidates = argCandidates;
	}

}
