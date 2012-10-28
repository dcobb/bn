package com.bignlp.langy.metamap.result;

import java.util.List;

import com.bignlp.langy.metamap.ConceptPair;
import com.bignlp.langy.metamap.Negation;
import com.bignlp.langy.metamap.Position;

public class MetaMapNegation {
	private String type;
	private String conceptId;
	private String trigger;
	private List<MetaMapPosition> triggerPositions;
	private List<MetaMapConceptPair> conceptPairs;
	private List<MetaMapPosition> conceptPositions;

	public MetaMapNegation() {
		super();
	}

	public MetaMapNegation(String argsType, String argsConceptId,
			String argsTrigger, List<MetaMapPosition> argsTriggerPositions,
			List<MetaMapConceptPair> argsConceptPairs,
			List<MetaMapPosition> argsConceptPositions) {
		super();
		this.type = argsType;
		this.conceptId = argsConceptId;
		this.trigger = argsTrigger;
		this.triggerPositions = argsTriggerPositions;
		this.conceptPairs = argsConceptPairs;
		this.conceptPositions = argsConceptPositions;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String argsType) {
		this.type = argsType;
	}

	public String getConceptId() {
		return this.conceptId;
	}

	public void setConceptId(String argsConceptId) {
		this.conceptId = argsConceptId;
	}

	public String getTrigger() {
		return this.trigger;
	}

	public void setTrigger(String argsTrigger) {
		this.trigger = argsTrigger;
	}

	public List<MetaMapPosition> getTriggerPositions() {
		return this.triggerPositions;
	}

	public void setTriggerPositions(List<MetaMapPosition> argsTriggerPositions) {
		this.triggerPositions = argsTriggerPositions;
	}

	public List<MetaMapConceptPair> getConceptPairs() {
		return this.conceptPairs;
	}

	public void setConceptPairs(List<MetaMapConceptPair> argsConceptPairs) {
		this.conceptPairs = argsConceptPairs;
	}

	public List<MetaMapPosition> getConceptPositions() {
		return this.conceptPositions;
	}

	public void setConceptPositions(List<MetaMapPosition> argsConceptPositions) {
		this.conceptPositions = argsConceptPositions;
	}

}
