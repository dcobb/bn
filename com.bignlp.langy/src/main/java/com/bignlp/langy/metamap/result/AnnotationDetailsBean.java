package com.bignlp.langy.metamap.result;

import java.util.List;

public class AnnotationDetailsBean {
	private List<PhrasePartBean> phraseParts;
	private List<OntologyReferenceBean> ontologyReferences;
	private List<WebReferenceBean> webReferences;

	public AnnotationDetailsBean() {
		super();
	}

	public AnnotationDetailsBean(List<PhrasePartBean> argsPhraseParts,
			List<OntologyReferenceBean> argsOntologyReferences,
			List<WebReferenceBean> argsWebReferences) {
		super();
		this.phraseParts = argsPhraseParts;
		this.ontologyReferences = argsOntologyReferences;
		this.webReferences = argsWebReferences;
	}

	public List<PhrasePartBean> getPhraseParts() {
		return this.phraseParts;
	}

	public void setPhraseParts(List<PhrasePartBean> argsPhraseParts) {
		this.phraseParts = argsPhraseParts;
	}

	public List<OntologyReferenceBean> getOntologyReferences() {
		return this.ontologyReferences;
	}

	public void setOntologyReferences(
			List<OntologyReferenceBean> argsOntologyReferences) {
		this.ontologyReferences = argsOntologyReferences;
	}

	public List<WebReferenceBean> getWebReferences() {
		return this.webReferences;
	}

	public void setWebReferences(List<WebReferenceBean> argsWebReferences) {
		this.webReferences = argsWebReferences;
	}

	@Override
	public String toString() {
		return "AnnotationDetailsBean [phraseParts=" + this.phraseParts
				+ ", ontologyReferences=" + this.ontologyReferences
				+ ", webReferences=" + this.webReferences + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((this.ontologyReferences == null) ? 0
						: this.ontologyReferences.hashCode());
		result = prime
				* result
				+ ((this.phraseParts == null) ? 0 : this.phraseParts.hashCode());
		result = prime
				* result
				+ ((this.webReferences == null) ? 0 : this.webReferences
						.hashCode());
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
		AnnotationDetailsBean other = (AnnotationDetailsBean) obj;
		if (this.ontologyReferences == null) {
			if (other.ontologyReferences != null)
				return false;
		} else if (!this.ontologyReferences.equals(other.ontologyReferences))
			return false;
		if (this.phraseParts == null) {
			if (other.phraseParts != null)
				return false;
		} else if (!this.phraseParts.equals(other.phraseParts))
			return false;
		if (this.webReferences == null) {
			if (other.webReferences != null)
				return false;
		} else if (!this.webReferences.equals(other.webReferences))
			return false;
		return true;
	}

}
