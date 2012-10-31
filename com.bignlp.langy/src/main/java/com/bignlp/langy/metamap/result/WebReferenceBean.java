package com.bignlp.langy.metamap.result;

public class WebReferenceBean {
	private String source;
	private String url;
	private String summary;

	public WebReferenceBean() {
		super();
	}

	public WebReferenceBean(String argsSource, String argsUrl,
			String argsSummary) {
		super();
		this.source = argsSource;
		this.url = argsUrl;
		this.summary = argsSummary;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String argsSource) {
		this.source = argsSource;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String argsUrl) {
		this.url = argsUrl;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String argsSummary) {
		this.summary = argsSummary;
	}

	@Override
	public String toString() {
		return "WebReferenceBean [source=" + this.source + ", url=" + this.url
				+ ", summary=" + this.summary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.source == null) ? 0 : this.source.hashCode());
		result = prime * result
				+ ((this.summary == null) ? 0 : this.summary.hashCode());
		result = prime * result
				+ ((this.url == null) ? 0 : this.url.hashCode());
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
		WebReferenceBean other = (WebReferenceBean) obj;
		if (this.source == null) {
			if (other.source != null)
				return false;
		} else if (!this.source.equals(other.source))
			return false;
		if (this.summary == null) {
			if (other.summary != null)
				return false;
		} else if (!this.summary.equals(other.summary))
			return false;
		if (this.url == null) {
			if (other.url != null)
				return false;
		} else if (!this.url.equals(other.url))
			return false;
		return true;
	}

}
