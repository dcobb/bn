package com.bignlp.langy.wsd;

import java.util.List;

public class Candidate {
	private int score;
	private String umlsConcept;
	private String preferredConceptName;
	private String matchedWords;
	private List<String> semTypes;
	private String matchMap;
	private boolean headFlag;
	private boolean overmatchFlag;

	public Candidate() {
		super();
	}

	public Candidate(int argScore, String argUmlsConcept,
			String argPreferredConceptName, String argMatchedWords,
			List<String> argSemTypes, String argMatchMap, boolean argHeadFlag,
			boolean argOvermatchFlag) {
		super();
		this.score = argScore;
		this.umlsConcept = argUmlsConcept;
		this.preferredConceptName = argPreferredConceptName;
		this.matchedWords = argMatchedWords;
		this.semTypes = argSemTypes;
		this.matchMap = argMatchMap;
		this.headFlag = argHeadFlag;
		this.overmatchFlag = argOvermatchFlag;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int argScore) {
		this.score = argScore;
	}

	public String getUmlsConcept() {
		return this.umlsConcept;
	}

	public void setUmlsConcept(String argUmlsConcept) {
		this.umlsConcept = argUmlsConcept;
	}

	public String getPreferredConceptName() {
		return this.preferredConceptName;
	}

	public void setPreferredConceptName(String argPreferredConceptName) {
		this.preferredConceptName = argPreferredConceptName;
	}

	public String getMatchedWords() {
		return this.matchedWords;
	}

	public void setMatchedWords(String argMatchedWords) {
		this.matchedWords = argMatchedWords;
	}

	public List<String> getSemTypes() {
		return this.semTypes;
	}

	public void setSemTypes(List<String> argSemTypes) {
		this.semTypes = argSemTypes;
	}

	public String getMatchMap() {
		return this.matchMap;
	}

	public void setMatchMap(String argMatchMap) {
		this.matchMap = argMatchMap;
	}

	public boolean isHeadFlag() {
		return this.headFlag;
	}

	public void setHeadFlag(boolean argHeadFlag) {
		this.headFlag = argHeadFlag;
	}

	public boolean isOvermatchFlag() {
		return this.overmatchFlag;
	}

	public void setOvermatchFlag(boolean argOvermatchFlag) {
		this.overmatchFlag = argOvermatchFlag;
	}

}
