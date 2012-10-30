package com.bignlp.langy.metamap.result;

import java.util.ArrayList;
import java.util.List;

import com.bignlp.langy.metamap.AcronymsAbbrevs;
import com.bignlp.langy.metamap.Candidates;
import com.bignlp.langy.metamap.ConceptPair;
import com.bignlp.langy.metamap.Ev;
import com.bignlp.langy.metamap.Mapping;
import com.bignlp.langy.metamap.Negation;
import com.bignlp.langy.metamap.PCM;
import com.bignlp.langy.metamap.Phrase;
import com.bignlp.langy.metamap.Position;
import com.bignlp.langy.metamap.Result;
import com.bignlp.langy.metamap.Utterance;

public class MetaMapUtils {

	public static MetaMapResult createMetaMapResult(Result argResult) {

		if (argResult != null) {
			MetaMapResult result = new MetaMapResult();

			String inputText = argResult.getInputText();
			if (inputText != null && !inputText.isEmpty()) {
				result.setInputText(inputText);
			}
			try {
				List<MetaMapAcronym> mmAcronyms = buildMetaMapAcronym(argResult);
				if (mmAcronyms != null && mmAcronyms.size() > 0) {
					result.setAcronyms(mmAcronyms);
				}
				List<MetaMapNegation> metaMapNegations = buildMetaMapNegation(argResult);
				if (metaMapNegations != null && metaMapNegations.size() > 0) {
					result.setNegations(metaMapNegations);
				}
				List<MetaMapUtterance> metaMapUtterancesList = buildMetaMapUtterance(argResult);
				if (metaMapUtterancesList != null
						&& metaMapUtterancesList.size() > 0) {
					result.setUtterences(metaMapUtterancesList);
				}
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private static List<MetaMapUtterance> buildMetaMapUtterance(Result argResult)
			throws Exception {
		List<Utterance> utterancesList = argResult.getUtteranceList();
		if (utterancesList != null && utterancesList.size() > 0) {
			List<MetaMapUtterance> metaMapUtterancesList = new ArrayList<MetaMapUtterance>();
			for (Utterance utterance : utterancesList) {
				MetaMapUtterance metaMapUtterance = new MetaMapUtterance();
				metaMapUtterance.setId(utterance.getId());
				metaMapUtterance.setText(utterance.getString());

				Position position = utterance.getPosition();
				if (position != null) {
					MetaMapPosition metaMapPosition = new MetaMapPosition();
					metaMapPosition.setX(position.getX());
					metaMapPosition.setY(position.getY());
					metaMapUtterance.setPosition(metaMapPosition);
				}
				List<MetaMapPhraseConceptMapping> metaMapPhraseConceptMappingsList = new ArrayList<MetaMapPhraseConceptMapping>(); // buildPhraseConceptmapping(utterance);
				if (metaMapPhraseConceptMappingsList != null) {
					metaMapUtterance
							.setPhraseConceptMappings(metaMapPhraseConceptMappingsList);
				}
				metaMapUtterancesList.add(metaMapUtterance);
			}
			return metaMapUtterancesList;
		}
		return null;
	}

	private static List<MetaMapPhraseConceptMapping> buildPhraseConceptmapping(
			Utterance argUtterance) throws Exception {
		if (argUtterance != null) {
			List<PCM> pcmList = argUtterance.getPCMList();
			if (pcmList != null && pcmList.size() > 0) {
				List<MetaMapPhraseConceptMapping> metaMapPhraseConceptMappingsList = new ArrayList<MetaMapPhraseConceptMapping>();
				for (PCM pcm : pcmList) {
					MetaMapPhraseConceptMapping metaMapPhraseConceptMapping = new MetaMapPhraseConceptMapping();
					MetaMapPhrase metaMapPhrase = buildMetaMapPhrase(pcm);
					if (metaMapPhrase != null) {
						metaMapPhraseConceptMapping.setPhrase(metaMapPhrase);
					}
					MetaMapCandidates metaMapCandidates = new MetaMapCandidates(); // buildMetaMapCandidates(pcm);
					if (metaMapCandidates != null) {
						metaMapPhraseConceptMapping
								.setCandidateInstance(metaMapCandidates);
					}
					List<Ev> candidatesList = new ArrayList<Ev>(); // pcm.getCandidateList();
					List<MetaMapEvaluation> metaMapEvaluationsList = buildEvList(candidatesList);
					if (metaMapEvaluationsList != null
							&& metaMapEvaluationsList.size() > 0) {
						metaMapPhraseConceptMapping
								.setCandidates(metaMapEvaluationsList);
					}
					List<MetaMapMapping> metaMapMappingsList = buildMappingList(pcm);
					if (metaMapMappingsList != null
							&& metaMapMappingsList.size() > 0) {
						metaMapPhraseConceptMapping
								.setMetaMapMappings(metaMapMappingsList);
					}
					metaMapPhraseConceptMappingsList
							.add(metaMapPhraseConceptMapping);
				}
				return metaMapPhraseConceptMappingsList;
			}
		}
		return null;
	}

	private static List<MetaMapMapping> buildMappingList(PCM argPcm)
			throws Exception {
		if (argPcm != null) {
			List<Mapping> mappingsList = argPcm.getMappingList();
			if (mappingsList != null && mappingsList.size() > 0) {
				List<MetaMapMapping> metaMapMappingsList = new ArrayList<MetaMapMapping>();
				for (Mapping mapping : mappingsList) {
					MetaMapMapping metaMapMapping = new MetaMapMapping();
					List<MetaMapEvaluation> metaMapEvaluations = buildEvList(mapping
							.getEvList());
					if (metaMapEvaluations != null
							&& metaMapEvaluations.size() > 0) {
						metaMapMapping.setEvaluations(metaMapEvaluations);
					}
					metaMapMapping.setScore(mapping.getScore());
					metaMapMappingsList.add(metaMapMapping);
				}
				return metaMapMappingsList;
			}
		}
		return null;
	}

	private static MetaMapPhrase buildMetaMapPhrase(PCM argPcm)
			throws Exception {
		if (argPcm != null) {
			Phrase phrase = argPcm.getPhrase();
			if (phrase != null) {
				MetaMapPhrase metaMapPhrase = new MetaMapPhrase();
				metaMapPhrase.setMincoMan(phrase.getMincoManAsString());
				metaMapPhrase.setPhraseText(phrase.getPhraseText());
				Position phrasePosition = phrase.getPosition();
				if (phrasePosition != null) {
					MetaMapPosition metaMapPhrasePosition = new MetaMapPosition();
					metaMapPhrasePosition.setX(phrasePosition.getX());
					metaMapPhrasePosition.setY(phrasePosition.getY());
					metaMapPhrase.setPosition(metaMapPhrasePosition);
				}
				return metaMapPhrase;
			}
		}
		return null;
	}

	private static MetaMapCandidates buildMetaMapCandidates(PCM argPcm)
			throws Exception {
		if (argPcm != null) {
			Candidates candidatesInstance = argPcm.getCandidatesInstance();
			if (candidatesInstance != null) {
				MetaMapCandidates metaMapCandidates = new MetaMapCandidates();
				List<Ev> evList = candidatesInstance.getEvList();
				List<MetaMapEvaluation> metaMapEvaluationsList = buildEvList(evList);
				if (metaMapEvaluationsList != null
						&& metaMapEvaluationsList.size() > 0) {
					metaMapCandidates.setEvs(metaMapEvaluationsList);
				}
				metaMapCandidates.setExcludedCandidateCount(candidatesInstance
						.getExcludedCandidateCount());
				metaMapCandidates.setPrunedCandidateCount(candidatesInstance
						.getPrunedCandidateCount());
				metaMapCandidates.setRemainingCandidates(candidatesInstance
						.getRemainingCandidates());
				metaMapCandidates.setTotalCandidatesCount(candidatesInstance
						.getTotalCandidatesCount());
				return metaMapCandidates;
			}
		}
		return null;
	}

	private static List<MetaMapEvaluation> buildEvList(List<Ev> argEvList)
			throws Exception {
		if (argEvList != null && argEvList.size() > 0) {
			List<MetaMapEvaluation> metaMapEvaluationsList = new ArrayList<MetaMapEvaluation>();
			for (Ev ev : argEvList) {
				MetaMapEvaluation metaMapEvaluation = new MetaMapEvaluation();
				metaMapEvaluation.setConceptId(ev.getConceptId());
				metaMapEvaluation.setConceptName(ev.getConceptName());
				metaMapEvaluation.setHead(ev.isHead());
				metaMapEvaluation.setMatchedWords(ev.getMatchedWords());
				metaMapEvaluation.setMatchMap(ev.getMatchMap());
				metaMapEvaluation.setMatchMaps(ev.getMatchMapList());
				metaMapEvaluation.setOvermatch(ev.isOvermatch());
				List<Position> positionsList = ev.getPositionalInfo();
				if (positionsList != null && positionsList.size() > 0) {
					List<MetaMapPosition> metaMapPositionsList = new ArrayList<MetaMapPosition>();
					for (Position position : positionsList) {
						MetaMapPosition metaMapPosition = new MetaMapPosition();
						metaMapPosition.setX(position.getX());
						metaMapPosition.setY(position.getY());
						metaMapPositionsList.add(metaMapPosition);
					}
					metaMapEvaluation.setPositions(metaMapPositionsList);
				}
				metaMapEvaluation.setPreferredName(ev.getPreferredName());
				metaMapEvaluation.setPruningStatus(ev.getPruningStatus());
				metaMapEvaluation.setScore(ev.getScore());
				metaMapEvaluation.setSemanticTypes(ev.getSemanticTypes());
				metaMapEvaluation.setSources(ev.getSources());
				metaMapEvaluationsList.add(metaMapEvaluation);
			}
			return metaMapEvaluationsList;
		}
		return null;
	}

	private static List<MetaMapAcronym> buildMetaMapAcronym(Result argResult)
			throws Exception {
		List<MetaMapAcronym> mmAcronyms = new ArrayList<MetaMapAcronym>();
		List<AcronymsAbbrevs> resultAcronyms = argResult
				.getAcronymsAbbrevsList();
		if (resultAcronyms != null && resultAcronyms.size() > 0) {
			for (AcronymsAbbrevs acronymsAbbrevs : resultAcronyms) {
				MetaMapAcronym mmAcronym = new MetaMapAcronym();
				mmAcronym.setAbbreviation(acronymsAbbrevs.getAcronym());
				mmAcronym.setExpansion(acronymsAbbrevs.getExpansion());
				mmAcronym.setCounts(acronymsAbbrevs.getCountList());
				mmAcronym.setCuis(acronymsAbbrevs.getCUIList());
				mmAcronyms.add(mmAcronym);
			}
		}
		return mmAcronyms;
	}

	private static List<MetaMapNegation> buildMetaMapNegation(Result argResult)
			throws Exception {
		List<MetaMapNegation> metaMapNegationList = new ArrayList<MetaMapNegation>();
		List<Negation> negationList = argResult.getNegationList();
		if (negationList != null && negationList.size() > 0) {
			for (Negation negation : negationList) {
				MetaMapNegation metaMapNegation = new MetaMapNegation();
				metaMapNegation.setConceptId(negation.getConceptId());
				metaMapNegation.setTrigger(negation.getTrigger());
				metaMapNegation.setType(negation.getType());

				List<Position> triggerPositionList = negation
						.getTriggerPositionList();
				if (triggerPositionList != null
						&& triggerPositionList.size() > 0) {
					List<MetaMapPosition> metaMapPositionsList = new ArrayList<MetaMapPosition>();
					for (Position position : triggerPositionList) {
						MetaMapPosition metaMapPosition = new MetaMapPosition();
						metaMapPosition.setX(position.getX());
						metaMapPosition.setY(position.getY());
						metaMapPositionsList.add(metaMapPosition);
					}
					metaMapNegation.setTriggerPositions(metaMapPositionsList);
				}

				List<Position> conceptPositionList = negation
						.getConceptPositionList();
				if (conceptPositionList != null
						&& conceptPositionList.size() > 0) {
					List<MetaMapPosition> conceptPositionsList = new ArrayList<MetaMapPosition>();
					for (Position position : conceptPositionList) {
						MetaMapPosition metaMapPosition = new MetaMapPosition();
						metaMapPosition.setX(position.getX());
						metaMapPosition.setY(position.getY());
						conceptPositionsList.add(metaMapPosition);
					}
					metaMapNegation.setConceptPositions(conceptPositionsList);
				}

				List<ConceptPair> metaMapConceptPairList = negation
						.getConceptPairList();
				if (metaMapConceptPairList != null
						&& metaMapConceptPairList.size() > 0) {
					List<MetaMapConceptPair> metaMapConceptPairsList = new ArrayList<MetaMapConceptPair>();
					for (ConceptPair conceptPair : metaMapConceptPairList) {
						MetaMapConceptPair metaMapConceptPair = new MetaMapConceptPair();
						metaMapConceptPair.setConceptId(conceptPair
								.getConceptId());
						metaMapConceptPair.setPreferredName(conceptPair
								.getPreferredName());
						metaMapConceptPairsList.add(metaMapConceptPair);
					}
					metaMapNegation.setConceptPairs(metaMapConceptPairsList);
				}
				metaMapNegationList.add(metaMapNegation);
			}
		}
		return metaMapNegationList;
	}

	public static List<MetaMapResult> createMetaMapResults(
			List<Result> argsResults) {
		List<MetaMapResult> mmResults = new ArrayList<MetaMapResult>();
		for (Result result : argsResults) {
			mmResults.add(createMetaMapResult(result));
		}
		return mmResults;
	}
}
