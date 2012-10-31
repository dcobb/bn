package com.bignlp.langy.metamap.result;

public class DocumentBean {
	private String documentId;
	private String contentType;
	private String fileName;
	private String dateCreated;
	private String dateAnnotated;

	public DocumentBean() {
		super();
	}

	public DocumentBean(String argsDocumentId, String argsContentType,
			String argsFileName, String argsDateCreated,
			String argsDateAnnotated) {
		super();
		this.documentId = argsDocumentId;
		this.contentType = argsContentType;
		this.fileName = argsFileName;
		this.dateCreated = argsDateCreated;
		this.dateAnnotated = argsDateAnnotated;
	}

	public String getDocumentId() {
		return this.documentId;
	}

	public void setDocumentId(String argsDocumentId) {
		this.documentId = argsDocumentId;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String argsContentType) {
		this.contentType = argsContentType;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String argsFileName) {
		this.fileName = argsFileName;
	}

	public String getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(String argsDateCreated) {
		this.dateCreated = argsDateCreated;
	}

	public String getDateAnnotated() {
		return this.dateAnnotated;
	}

	public void setDateAnnotated(String argsDateAnnotated) {
		this.dateAnnotated = argsDateAnnotated;
	}

	@Override
	public String toString() {
		return "DocumentBean [documentId=" + this.documentId + ", contentType="
				+ this.contentType + ", fileName=" + this.fileName
				+ ", dateCreated=" + this.dateCreated + ", dateAnnotated="
				+ this.dateAnnotated + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((this.contentType == null) ? 0 : this.contentType.hashCode());
		result = prime
				* result
				+ ((this.dateAnnotated == null) ? 0 : this.dateAnnotated
						.hashCode());
		result = prime
				* result
				+ ((this.dateCreated == null) ? 0 : this.dateCreated.hashCode());
		result = prime * result
				+ ((this.documentId == null) ? 0 : this.documentId.hashCode());
		result = prime * result
				+ ((this.fileName == null) ? 0 : this.fileName.hashCode());
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
		DocumentBean other = (DocumentBean) obj;
		if (this.contentType == null) {
			if (other.contentType != null)
				return false;
		} else if (!this.contentType.equals(other.contentType))
			return false;
		if (this.dateAnnotated == null) {
			if (other.dateAnnotated != null)
				return false;
		} else if (!this.dateAnnotated.equals(other.dateAnnotated))
			return false;
		if (this.dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!this.dateCreated.equals(other.dateCreated))
			return false;
		if (this.documentId == null) {
			if (other.documentId != null)
				return false;
		} else if (!this.documentId.equals(other.documentId))
			return false;
		if (this.fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!this.fileName.equals(other.fileName))
			return false;
		return true;
	}

}
