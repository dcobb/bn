package com.bignlp.langy.metamap.result;

import java.io.Serializable;
import java.util.List;

import com.bignlp.langy.metamap.MatchMap;

public class MetaMapEvaluation  implements Serializable {
	private int score;
	private String conceptId;
	private String conceptName;
	private String preferredName;
	private List<String> matchedWords;
	private List<String> semanticTypes;
	private List<Object> matchMap;
	private List<MatchMap> matchMaps;
	private boolean head;
	private boolean overmatch;
	private List<String> sources;
	private List<MetaMapPosition> positions;
	private int pruningStatus;

	public MetaMapEvaluation() {
		super();
	}

	public MetaMapEvaluation(int argsScore, String argsConceptId,
			String argsConceptName, String argsPreferredName,
			List<String> argsMatchedWords, List<String> argsSemanticTypes,
			List<Object> argsMatchMap, List<MatchMap> argsMatchMaps,
			boolean argsHead, boolean argsOvermatch, List<String> argsSources,
			List<MetaMapPosition> argsPositions, int argsPruningStatus) {
		super();
		this.score = argsScore;
		this.conceptId = argsConceptId;
		this.conceptName = argsConceptName;
		this.preferredName = argsPreferredName;
		this.matchedWords = argsMatchedWords;
		this.semanticTypes = argsSemanticTypes;
		this.matchMap = argsMatchMap;
		this.matchMaps = argsMatchMaps;
		this.head = argsHead;
		this.overmatch = argsOvermatch;
		this.sources = argsSources;
		this.positions = argsPositions;
		this.pruningStatus = argsPruningStatus;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int argsScore) {
		this.score = argsScore;
	}

	public String getConceptId() {
		return this.conceptId;
	}

	public void setConceptId(String argsConceptId) {
		this.conceptId = argsConceptId;
	}

	public String getConceptName() {
		return this.conceptName;
	}

	public void setConceptName(String argsConceptName) {
		this.conceptName = argsConceptName;
	}

	public String getPreferredName() {
		return this.preferredName;
	}

	public void setPreferredName(String argsPreferredName) {
		this.preferredName = argsPreferredName;
	}

	public List<String> getMatchedWords() {
		return this.matchedWords;
	}

	public void setMatchedWords(List<String> argsMatchedWords) {
		this.matchedWords = argsMatchedWords;
	}

	public List<String> getSemanticTypes() {
		return this.semanticTypes;
	}

	public void setSemanticTypes(List<String> argsSemanticTypes) {
		this.semanticTypes = argsSemanticTypes;
	}

	public List<Object> getMatchMap() {
		return this.matchMap;
	}

	public void setMatchMap(List<Object> argsMatchMap) {
		this.matchMap = argsMatchMap;
	}

	public List<MatchMap> getMatchMaps() {
		return this.matchMaps;
	}

	public void setMatchMaps(List<MatchMap> argsMatchMaps) {
		this.matchMaps = argsMatchMaps;
	}

	public boolean isHead() {
		return this.head;
	}

	public void setHead(boolean argsHead) {
		this.head = argsHead;
	}

	public boolean isOvermatch() {
		return this.overmatch;
	}

	public void setOvermatch(boolean argsOvermatch) {
		this.overmatch = argsOvermatch;
	}

	public List<String> getSources() {
		return this.sources;
	}

	public void setSources(List<String> argsSources) {
		this.sources = argsSources;
	}

	public List<MetaMapPosition> getPositions() {
		return this.positions;
	}

	public void setPositions(List<MetaMapPosition> argsPositions) {
		this.positions = argsPositions;
	}

	public int getPruningStatus() {
		return this.pruningStatus;
	}

	public void setPruningStatus(int argsPruningStatus) {
		this.pruningStatus = argsPruningStatus;
	}

}
