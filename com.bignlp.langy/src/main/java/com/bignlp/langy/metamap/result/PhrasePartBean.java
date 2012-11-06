package com.bignlp.langy.metamap.result;

import java.util.List;

public class PhrasePartBean {
	private int startPosition;
	private int endPosition;
	private String phrase;
	private String conceptName;
	private List<String> tags;
	private String summary;

	public PhrasePartBean() {
		super();
	}

	public PhrasePartBean(int argsStartPosition, int argsEndPosition,
			String argsPhrase, List<String> argsTags, String argsSummary) {
		super();
		this.startPosition = argsStartPosition;
		this.endPosition = argsEndPosition;
		this.phrase = argsPhrase;
		this.tags = argsTags;
		this.summary = argsSummary;
	}

	public String getConceptName() {
		return this.conceptName;
	}

	public void setConceptName(String argsConceptName) {
		this.conceptName = argsConceptName;
	}

	public int getStartPosition() {
		return this.startPosition;
	}

	public void setStartPosition(int argsStartPosition) {
		this.startPosition = argsStartPosition;
	}

	public int getEndPosition() {
		return this.endPosition;
	}

	public void setEndPosition(int argsEndPosition) {
		this.endPosition = argsEndPosition;
	}

	public String getPhrase() {
		return this.phrase;
	}

	public void setPhrase(String argsPhrase) {
		this.phrase = argsPhrase;
	}

	public List<String> getTags() {
		return this.tags;
	}

	public void setTags(List<String> argsTags) {
		this.tags = argsTags;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String argsSummary) {
		this.summary = argsSummary;
	}

	@Override
	public String toString() {
		return "PhrasePartBean [startPosition=" + this.startPosition
				+ ", endPosition=" + this.endPosition + ", phrase="
				+ this.phrase + ", tags=" + this.tags + ", summary="
				+ this.summary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.endPosition;
		result = prime * result
				+ ((this.phrase == null) ? 0 : this.phrase.hashCode());
		result = prime * result + this.startPosition;
		result = prime * result
				+ ((this.summary == null) ? 0 : this.summary.hashCode());
		result = prime * result
				+ ((this.tags == null) ? 0 : this.tags.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhrasePartBean other = (PhrasePartBean) obj;
		if (this.endPosition != other.endPosition)
			return false;
		if (this.phrase == null) {
			if (other.phrase != null)
				return false;
		} else if (!this.phrase.equals(other.phrase))
			return false;
		if (this.startPosition != other.startPosition)
			return false;
		if (this.summary == null) {
			if (other.summary != null)
				return false;
		} else if (!this.summary.equals(other.summary))
			return false;
		if (this.tags == null) {
			if (other.tags != null)
				return false;
		} else if (!this.tags.equals(other.tags))
			return false;
		return true;
	}

}
