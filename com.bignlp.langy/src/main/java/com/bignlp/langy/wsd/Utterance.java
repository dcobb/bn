package com.bignlp.langy.wsd;

import java.util.List;

public class Utterance {
	private String id;
	private String sentence;
	private int position;
	private List<NounPhrase> nounPhrases;

	public Utterance() {
		super();
	}

	public Utterance(String argId, String argSentence, int argPos,
			List<NounPhrase> argNounPhrases) {
		super();
		this.id = argId;
		this.sentence = argSentence;
		this.position = argPos;
		this.nounPhrases = argNounPhrases;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String argId) {
		this.id = argId;
	}

	public String getSentence() {
		return this.sentence;
	}

	public void setSentence(String argSentence) {
		this.sentence = argSentence;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int argPos) {
		this.position = argPos;
	}

	public List<NounPhrase> getNounPhrases() {
		return this.nounPhrases;
	}

	public void setNounPhrases(List<NounPhrase> argNounPhrases) {
		this.nounPhrases = argNounPhrases;
	}

}
