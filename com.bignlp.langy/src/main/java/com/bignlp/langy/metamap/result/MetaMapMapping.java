package com.bignlp.langy.metamap.result;

import java.util.List;

public class MetaMapMapping {
	private int score;
	private List<MetaMapEvaluation> evaluations;

	public MetaMapMapping() {
		super();
	}

	public MetaMapMapping(int argsScore, List<MetaMapEvaluation> argsEvaluations) {
		super();
		this.score = argsScore;
		this.evaluations = argsEvaluations;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int argsScore) {
		this.score = argsScore;
	}

	public List<MetaMapEvaluation> getEvaluations() {
		return this.evaluations;
	}

	public void setEvaluations(List<MetaMapEvaluation> argsEvaluations) {
		this.evaluations = argsEvaluations;
	}

}
