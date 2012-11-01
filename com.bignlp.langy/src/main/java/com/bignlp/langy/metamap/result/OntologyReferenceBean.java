package com.bignlp.langy.metamap.result;

public class OntologyReferenceBean {
	private String ontology;
	private String version;
	private String code;

	public OntologyReferenceBean() {
		super();
	}

	public OntologyReferenceBean(String argsOntology, String argsVersion,
			String argsCode) {
		super();
		this.ontology = argsOntology;
		this.version = argsVersion;
		this.code = argsCode;
	}

	public String getOntology() {
		return this.ontology;
	}

	public void setOntology(String argsOntology) {
		this.ontology = argsOntology;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String argsVersion) {
		this.version = argsVersion;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String argsCode) {
		this.code = argsCode;
	}

	@Override
	public String toString() {
		return "OntologyReferenceBean [ontology=" + this.ontology
				+ ", version=" + this.version + ", code=" + this.code + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.code == null) ? 0 : this.code.hashCode());
		result = prime * result
				+ ((this.ontology == null) ? 0 : this.ontology.hashCode());
		result = prime * result
				+ ((this.version == null) ? 0 : this.version.hashCode());
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
		OntologyReferenceBean other = (OntologyReferenceBean) obj;
		if (this.code == null) {
			if (other.code != null)
				return false;
		} else if (!this.code.equals(other.code))
			return false;
		if (this.ontology == null) {
			if (other.ontology != null)
				return false;
		} else if (!this.ontology.equals(other.ontology))
			return false;
		if (this.version == null) {
			if (other.version != null)
				return false;
		} else if (!this.version.equals(other.version))
			return false;
		return true;
	}

}
