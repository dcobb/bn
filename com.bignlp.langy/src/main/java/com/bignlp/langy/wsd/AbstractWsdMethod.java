package com.bignlp.langy.wsd;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWsdMethod implements WsdMethod {

	public static List<String> getPreferredConceptNames(
			List<Candidate> argCandidates) {
		List<Candidate> candidates = checkNotNull(argCandidates,
				"argCandidates cannot be null");
		checkArgument(candidates.size() > 0, "argCandidates cannot be empty");
		List<String> preferredConceptNames = new ArrayList<String>();
		for (Candidate candidate : candidates) {
			if (candidate != null) {
				String preferredConceptName = candidate
						.getPreferredConceptName();
				if (preferredConceptName != null
						&& !preferredConceptName.isEmpty()) {
					preferredConceptNames.add(preferredConceptName);
				}
			}
		}
		if (preferredConceptNames != null && !preferredConceptNames.isEmpty()) {
			return preferredConceptNames;
		}
		return null;
	}

	public List<WsdResult> getMatch(List<Utterance> argUtterances) {
		List<Utterance> utterances = checkNotNull(argUtterances,
				"argUtterances cannot be null");
		checkArgument(utterances.size() > 0, "argUtterances cannot be null");
		List<WsdResult> results = new ArrayList<WsdResult>();
		for (Utterance utterance : utterances) {
			List<NounPhrase> nounPhrases = utterance.getNounPhrases();
			if (nounPhrases != null && !nounPhrases.isEmpty()) {
				for (NounPhrase nounPhrase : nounPhrases) {
					List<Ambiguity> ambiguities = nounPhrase.getAmbiguities();
					if (ambiguities != null && !ambiguities.isEmpty()) {
						for (Ambiguity ambiguity : ambiguities) {
							List<Candidate> candidates = ambiguity
									.getCandidates();
							if (!ambiguity.isSkipProcessing()
									&& candidates != null
									&& !candidates.isEmpty()) {
								List<String> preferredConceptNames = getPreferredConceptNames(candidates);
								if (preferredConceptNames != null
										&& !preferredConceptNames.isEmpty()) {
									List<String> bestPreferredConceptNames = findMatch(preferredConceptNames);
									if (bestPreferredConceptNames != null
											&& !bestPreferredConceptNames
													.isEmpty()) {
										WsdResult result = new WsdResult();
										result.setCandidatePreferredConceptNames(preferredConceptNames);
										result.setPreferredConceptNames(bestPreferredConceptNames);
										result.setUtteranceId(utterance.getId());
										result.setPhrasePosition(nounPhrase
												.getPosition());
										result.setUtterencePosition(utterance
												.getPosition());
										results.add(result);
									}
								}
							}
						}
					}
				}
			}
		}
		if (results != null && !results.isEmpty()) {
			return results;
		}
		return null;
	}

	protected abstract List<String> findMatch(
			List<String> argPreferredConceptNames);

}
