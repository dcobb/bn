package com.bignlp.langy.metamap.result;

import java.util.List;

public class MetaMapCandidates {
	private int totalCandidatesCount;
	private int excludedCandidateCount;
	private int prunedCandidateCount;
	private int remainingCandidates;
	private List<MetaMapEvaluation> evs;

	public MetaMapCandidates() {
		super();
	}

	public MetaMapCandidates(int argsTotalCandidatesCount,
			int argsExcludedCandidateCount, int argsPrunedCandidateCount,
			int argsRemainingCandidates, List<MetaMapEvaluation> argsEvs) {
		super();
		this.totalCandidatesCount = argsTotalCandidatesCount;
		this.excludedCandidateCount = argsExcludedCandidateCount;
		this.prunedCandidateCount = argsPrunedCandidateCount;
		this.remainingCandidates = argsRemainingCandidates;
		this.evs = argsEvs;
	}

	public int getTotalCandidatesCount() {
		return this.totalCandidatesCount;
	}

	public void setTotalCandidatesCount(int argsTotalCandidatesCount) {
		this.totalCandidatesCount = argsTotalCandidatesCount;
	}

	public int getExcludedCandidateCount() {
		return this.excludedCandidateCount;
	}

	public void setExcludedCandidateCount(int argsExcludedCandidateCount) {
		this.excludedCandidateCount = argsExcludedCandidateCount;
	}

	public int getPrunedCandidateCount() {
		return this.prunedCandidateCount;
	}

	public void setPrunedCandidateCount(int argsPrunedCandidateCount) {
		this.prunedCandidateCount = argsPrunedCandidateCount;
	}

	public int getRemainingCandidates() {
		return this.remainingCandidates;
	}

	public void setRemainingCandidates(int argsRemainingCandidates) {
		this.remainingCandidates = argsRemainingCandidates;
	}

	public List<MetaMapEvaluation> getEvs() {
		return this.evs;
	}

	public void setEvs(List<MetaMapEvaluation> argsEvs) {
		this.evs = argsEvs;
	}

}
