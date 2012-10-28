package com.bignlp.langy.metamap.result;

import java.util.List;

public class MetaMapPhraseConceptMapping {
	private MetaMapPhrase phrase;
	private List<MetaMapEvaluation> candidates;
	private MetaMapCandidates candidateInstance;

	public MetaMapPhraseConceptMapping() {
		super();
	}

	public MetaMapPhraseConceptMapping(MetaMapPhrase argsPhrase,
			List<MetaMapEvaluation> argsCandidates,
			MetaMapCandidates argsCandidateInstance) {
		super();
		this.phrase = argsPhrase;
		this.candidates = argsCandidates;
		this.candidateInstance = argsCandidateInstance;
	}

	public MetaMapPhrase getPhrase() {
		return this.phrase;
	}

	public void setPhrase(MetaMapPhrase argsPhrase) {
		this.phrase = argsPhrase;
	}

	public List<MetaMapEvaluation> getCandidates() {
		return this.candidates;
	}

	public void setCandidates(List<MetaMapEvaluation> argsCandidates) {
		this.candidates = argsCandidates;
	}

	public MetaMapCandidates getCandidateInstance() {
		return this.candidateInstance;
	}

	public void setCandidateInstance(MetaMapCandidates argsCandidateInstance) {
		this.candidateInstance = argsCandidateInstance;
	}

}
