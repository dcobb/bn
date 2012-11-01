package com.bignlp.langy.metamap.result;

import java.io.Serializable;
import java.util.List;

public class MetaMapUtterance  implements Serializable{
	private String id;
	private String text;
	private MetaMapPosition position;
	private List<MetaMapPhraseCandidateMapping> phraseConceptMappings;

	public MetaMapUtterance() {
		super();
	}

	public MetaMapUtterance(String argsId, String argsText,
			MetaMapPosition argsPosition,
			List<MetaMapPhraseCandidateMapping> argsPhraseConceptMappings) {
		super();
		this.id = argsId;
		this.text = argsText;
		this.position = argsPosition;
		this.phraseConceptMappings = argsPhraseConceptMappings;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String argsId) {
		this.id = argsId;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String argsText) {
		this.text = argsText;
	}

	public MetaMapPosition getPosition() {
		return this.position;
	}

	public void setPosition(MetaMapPosition argsPosition) {
		this.position = argsPosition;
	}

	public List<MetaMapPhraseCandidateMapping> getPhraseConceptMappings() {
		return this.phraseConceptMappings;
	}

	public void setPhraseConceptMappings(
			List<MetaMapPhraseCandidateMapping> argsPhraseConceptMappings) {
		this.phraseConceptMappings = argsPhraseConceptMappings;
	}

}
