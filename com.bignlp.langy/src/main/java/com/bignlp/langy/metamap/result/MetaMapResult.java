package com.bignlp.langy.metamap.result;

import java.io.Serializable;
import java.util.List;

public class MetaMapResult  implements Serializable {
	private String inputText;
	private List<MetaMapAcronym> acronyms;
	private List<MetaMapNegation> negations;
	private List<MetaMapUtterance> utterences;

	public MetaMapResult() {
		super();
	}

	public MetaMapResult(String argInputText, List<MetaMapAcronym> argAcronyms,
			List<MetaMapNegation> argNegations,
			List<MetaMapUtterance> argUtterences) {
		super();
		this.inputText = argInputText;
		this.acronyms = argAcronyms;
		this.negations = argNegations;
		this.utterences = argUtterences;
	}

	public String getInputText() {
		return this.inputText;
	}

	public void setInputText(String argsInputText) {
		this.inputText = argsInputText;
	}

	public List<MetaMapAcronym> getAcronyms() {
		return this.acronyms;
	}

	public void setAcronyms(List<MetaMapAcronym> argsAcronyms) {
		this.acronyms = argsAcronyms;
	}

	public List<MetaMapNegation> getNegations() {
		return this.negations;
	}

	public void setNegations(List<MetaMapNegation> argNegations) {
		this.negations = argNegations;
	}

	public List<MetaMapUtterance> getUtterences() {
		return this.utterences;
	}

	public void setUtterences(List<MetaMapUtterance> argUtterences) {
		this.utterences = argUtterences;
	}

}
