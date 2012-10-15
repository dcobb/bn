package com.bignlp.langy.wsd;

import java.util.List;

public class WsdResult {
	private String disambiguationMethodName;
	private String utteranceId;
	private int utterencePosition;
	private int phrasePosition;
	private List<String> candidatePreferredConceptNames;
	private List<String> preferredConceptNames;

	public WsdResult() {
		super();
	}

	public WsdResult(String argDisambiguationMethodName, String argUtteranceId,
			int argUtterencePosition, int argPhrasePosition,
			List<String> argCandidatePreferredConceptNames,
			List<String> argPreferredConceptNames) {
		super();
		this.disambiguationMethodName = argDisambiguationMethodName;
		this.utteranceId = argUtteranceId;
		this.utterencePosition = argUtterencePosition;
		this.phrasePosition = argPhrasePosition;
		this.candidatePreferredConceptNames = argCandidatePreferredConceptNames;
		this.preferredConceptNames = argPreferredConceptNames;
	}

	public String getDisambiguationMethodName() {
		return this.disambiguationMethodName;
	}

	public void setDisambiguationMethodName(String argDisambiguationMethodName) {
		this.disambiguationMethodName = argDisambiguationMethodName;
	}

	public String getUtteranceId() {
		return this.utteranceId;
	}

	public void setUtteranceId(String argUtteranceId) {
		this.utteranceId = argUtteranceId;
	}

	public int getUtterencePosition() {
		return this.utterencePosition;
	}

	public void setUtterencePosition(int argUtterencePosition) {
		this.utterencePosition = argUtterencePosition;
	}

	public int getPhrasePosition() {
		return this.phrasePosition;
	}

	public void setPhrasePosition(int argPhrasePosition) {
		this.phrasePosition = argPhrasePosition;
	}

	public List<String> getCandidatePreferredConceptNames() {
		return this.candidatePreferredConceptNames;
	}

	public void setCandidatePreferredConceptNames(
			List<String> argCandidatePreferredConceptNames) {
		this.candidatePreferredConceptNames = argCandidatePreferredConceptNames;
	}

	public List<String> getPreferredConceptNames() {
		return this.preferredConceptNames;
	}

	public void setPreferredConceptNames(List<String> argPreferredConceptNames) {
		this.preferredConceptNames = argPreferredConceptNames;
	}

}
