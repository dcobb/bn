package com.bignlp.langy.metamap.result;

import java.io.Serializable;


public class MetaMapPhrase  implements Serializable{
	private String phraseText;
	private String mincoMan;
	private MetaMapPosition position;

	public MetaMapPhrase() {
		super();
	}

	public MetaMapPhrase(String argsPhraseText, String argsMincoMan,
			MetaMapPosition argsPosition) {
		super();
		this.phraseText = argsPhraseText;
		this.mincoMan = argsMincoMan;
		this.position = argsPosition;
	}

	public String getPhraseText() {
		return this.phraseText;
	}

	public void setPhraseText(String argsPhraseText) {
		this.phraseText = argsPhraseText;
	}

	public String getMincoMan() {
		return this.mincoMan;
	}

	public void setMincoMan(String argsMincoMan) {
		this.mincoMan = argsMincoMan;
	}

	public MetaMapPosition getPosition() {
		return this.position;
	}

	public void setPosition(MetaMapPosition argsPosition) {
		this.position = argsPosition;
	}

}
