package com.bignlp.langy.metamap.result;

import java.util.List;

import com.bignlp.langy.metamap.Negation;
import com.bignlp.langy.metamap.Utterance;

public class MetaMapResult {
	private String inputText;
	private List<MetaMapAcronym> acronyms;
	private List<Negation> negations;
	private List<Utterance> utterences;

	public MetaMapResult() {
		super();
	}

	public MetaMapResult(String argsInputText,
			List<MetaMapAcronym> argsAcronyms, List<Negation> argsNegations,
			List<Utterance> argsUtterences) {
		super();
		this.inputText = argsInputText;
		this.acronyms = argsAcronyms;
		this.negations = argsNegations;
		this.utterences = argsUtterences;
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

	public List<Negation> getNegations() {
		return this.negations;
	}

	public void setNegations(List<Negation> argsNegations) {
		this.negations = argsNegations;
	}

	public List<Utterance> getUtterences() {
		return this.utterences;
	}

	public void setUtterences(List<Utterance> argsUtterences) {
		this.utterences = argsUtterences;
	}

}
