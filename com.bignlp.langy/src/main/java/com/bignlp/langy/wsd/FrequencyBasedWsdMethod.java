package com.bignlp.langy.wsd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FrequencyBasedWsdMethod extends AbstractWsdMethod {

	private Map<String, String> myNameVsBestLookupMap;

	@Override
	protected List<String> findMatch(List<String> argPreferredConceptNames) {
		List<String> result = new ArrayList<String>();
		for (String preferredConceptName : argPreferredConceptNames) {
			String bestMatch = myNameVsBestLookupMap.get(preferredConceptName);
			result.add(bestMatch);
		}
		return (result != null && !result.isEmpty()) ? result : null;
	}

}
