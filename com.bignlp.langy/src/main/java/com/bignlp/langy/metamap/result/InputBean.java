package com.bignlp.langy.metamap.result;

public class InputBean {
	private String contentId;
	private String contentType;
	private String charSet;
	private String content;

	public InputBean() {
		super();
	}

	public InputBean(String argsContentId, String argsContentType,
			String argsCharSet, String argsContent) {
		super();
		this.contentId = argsContentId;
		this.contentType = argsContentType;
		this.charSet = argsCharSet;
		this.content = argsContent;
	}

	public String getContentId() {
		return this.contentId;
	}

	public void setContentId(String argsContentId) {
		this.contentId = argsContentId;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String argsContentType) {
		this.contentType = argsContentType;
	}

	public String getCharSet() {
		return this.charSet;
	}

	public void setCharSet(String argsCharSet) {
		this.charSet = argsCharSet;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String argsContent) {
		this.content = argsContent;
	}

	@Override
	public String toString() {
		return "InputBean [contentId=" + this.contentId + ", contentType="
				+ this.contentType + ", charSet=" + this.charSet + ", content="
				+ this.content + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.charSet == null) ? 0 : this.charSet.hashCode());
		result = prime * result
				+ ((this.content == null) ? 0 : this.content.hashCode());
		result = prime * result
				+ ((this.contentId == null) ? 0 : this.contentId.hashCode());
		result = prime
				* result
				+ ((this.contentType == null) ? 0 : this.contentType.hashCode());
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
		InputBean other = (InputBean) obj;
		if (this.charSet == null) {
			if (other.charSet != null)
				return false;
		} else if (!this.charSet.equals(other.charSet))
			return false;
		if (this.content == null) {
			if (other.content != null)
				return false;
		} else if (!this.content.equals(other.content))
			return false;
		if (this.contentId == null) {
			if (other.contentId != null)
				return false;
		} else if (!this.contentId.equals(other.contentId))
			return false;
		if (this.contentType == null) {
			if (other.contentType != null)
				return false;
		} else if (!this.contentType.equals(other.contentType))
			return false;
		return true;
	}

}
