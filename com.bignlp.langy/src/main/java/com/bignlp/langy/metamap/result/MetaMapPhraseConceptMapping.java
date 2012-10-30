package com.bignlp.langy.metamap.result;

import java.io.Serializable;
import java.util.List;

public class MetaMapPhraseConceptMapping  implements Serializable{
	private MetaMapPhrase phrase;
	private List<MetaMapEvaluation> candidates;
	private MetaMapCandidates candidateInstance;
	private List<MetaMapMapping> metaMapMappings;

	public MetaMapPhraseConceptMapping() {
		super();
	}

	public MetaMapPhraseConceptMapping(MetaMapPhrase argPhrase,
			List<MetaMapEvaluation> argCandidates,
			MetaMapCandidates argCandidateInstance,
			List<MetaMapMapping> argMetaMapMappings) {
		super();
		this.phrase = argPhrase;
		this.candidates = argCandidates;
		this.candidateInstance = argCandidateInstance;
		this.metaMapMappings = argMetaMapMappings;
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

	public List<MetaMapMapping> getMetaMapMappings() {
		return this.metaMapMappings;
	}

	public void setMetaMapMappings(List<MetaMapMapping> argMetaMapMappings) {
		this.metaMapMappings = argMetaMapMappings;
	}

}
