package com.bignlp.langy.metamap.result;

import java.util.List;

public class DocumentAnnotationsBean {
	private DocumentBean document;
	private InputBean input;
	private List<AnnotationBean> annotations;

	public DocumentAnnotationsBean() {
		super();
	}

	public DocumentAnnotationsBean(DocumentBean argsDocument,
			InputBean argsInput, List<AnnotationBean> argsAnnotations) {
		super();
		this.document = argsDocument;
		this.input = argsInput;
		this.annotations = argsAnnotations;
	}

	public DocumentBean getDocument() {
		return this.document;
	}

	public void setDocument(DocumentBean argsDocument) {
		this.document = argsDocument;
	}

	public InputBean getInput() {
		return this.input;
	}

	public void setInput(InputBean argsInput) {
		this.input = argsInput;
	}

	public List<AnnotationBean> getAnnotations() {
		return this.annotations;
	}

	public void setAnnotations(List<AnnotationBean> argsAnnotations) {
		this.annotations = argsAnnotations;
	}

	@Override
	public String toString() {
		return "DocumentAnnotationsBean [document=" + this.document
				+ ", input=" + this.input + ", annotations=" + this.annotations
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((this.annotations == null) ? 0 : this.annotations.hashCode());
		result = prime * result
				+ ((this.document == null) ? 0 : this.document.hashCode());
		result = prime * result
				+ ((this.input == null) ? 0 : this.input.hashCode());
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
		DocumentAnnotationsBean other = (DocumentAnnotationsBean) obj;
		if (this.annotations == null) {
			if (other.annotations != null)
				return false;
		} else if (!this.annotations.equals(other.annotations))
			return false;
		if (this.document == null) {
			if (other.document != null)
				return false;
		} else if (!this.document.equals(other.document))
			return false;
		if (this.input == null) {
			if (other.input != null)
				return false;
		} else if (!this.input.equals(other.input))
			return false;
		return true;
	}

}
