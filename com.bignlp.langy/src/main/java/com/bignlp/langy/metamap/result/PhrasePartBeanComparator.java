package com.bignlp.langy.metamap.result;

import java.util.Comparator;

public class PhrasePartBeanComparator implements Comparator<PhrasePartBean> {

	public int compare(PhrasePartBean argLhs, PhrasePartBean argRhs) {
		if (argLhs != null && argRhs != null) {
			if (argLhs.getStartPosition() == argRhs.getStartPosition()
					&& argLhs.getEndPosition() == argRhs.getEndPosition()
					&& argLhs.getPhrase().equals(argRhs.getPhrase())) {
				return 0;
			}
			return 1;
		} else {
			if (argLhs != null) {
				return -1;
			}
			if (argRhs != null) {
				return 1;
			}
		}
		return 0;
	}

}
