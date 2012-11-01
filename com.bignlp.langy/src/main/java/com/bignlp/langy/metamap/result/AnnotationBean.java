package com.bignlp.langy.metamap.result;

import java.util.List;

public class AnnotationBean {
	private int startPosition;
	private int endPosition;
	private String phrase;
	private List<String> tags;
	private AnnotationDetailsBean details;

	public AnnotationBean() {
		super();
	}

	public AnnotationBean(int argsStartPosition, int argsEndPosition,
			String argsPhrase, List<String> argsTags,
			AnnotationDetailsBean argsDetails) {
		super();
		this.startPosition = argsStartPosition;
		this.endPosition = argsEndPosition;
		this.phrase = argsPhrase;
		this.tags = argsTags;
		this.details = argsDetails;
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

	public AnnotationDetailsBean getDetails() {
		return this.details;
	}

	public void setDetails(AnnotationDetailsBean argsDetails) {
		this.details = argsDetails;
	}

	@Override
	public String toString() {
		return "AnnotationBean [startPosition=" + this.startPosition
				+ ", endPosition=" + this.endPosition + ", phrase="
				+ this.phrase + ", tags=" + this.tags + ", details="
				+ this.details + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.details == null) ? 0 : this.details.hashCode());
		result = prime * result + this.endPosition;
		result = prime * result
				+ ((this.phrase == null) ? 0 : this.phrase.hashCode());
		result = prime * result + this.startPosition;
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
		AnnotationBean other = (AnnotationBean) obj;
		if (this.details == null) {
			if (other.details != null)
				return false;
		} else if (!this.details.equals(other.details))
			return false;
		if (this.endPosition != other.endPosition)
			return false;
		if (this.phrase == null) {
			if (other.phrase != null)
				return false;
		} else if (!this.phrase.equals(other.phrase))
			return false;
		if (this.startPosition != other.startPosition)
			return false;
		if (this.tags == null) {
			if (other.tags != null)
				return false;
		} else if (!this.tags.equals(other.tags))
			return false;
		return true;
	}

}
