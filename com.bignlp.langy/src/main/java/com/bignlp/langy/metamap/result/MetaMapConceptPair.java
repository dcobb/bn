package com.bignlp.langy.metamap.result;

import com.bignlp.langy.metamap.ConceptPair;

public class MetaMapConceptPair implements ConceptPair {
	private String conceptId;
	private String preferredName;

	public MetaMapConceptPair() {
		super();
	}

	public MetaMapConceptPair(String argsConceptId, String argsPreferredName) {
		super();
		this.conceptId = argsConceptId;
		this.preferredName = argsPreferredName;
	}

	public String getConceptId() {
		return this.conceptId;
	}

	public void setConceptId(String argsConceptId) {
		this.conceptId = argsConceptId;
	}

	public String getPreferredName() {
		return this.preferredName;
	}

	public void setPreferredName(String argsPreferredName) {
		this.preferredName = argsPreferredName;
	}

}
