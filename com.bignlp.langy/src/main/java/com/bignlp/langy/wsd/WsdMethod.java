package com.bignlp.langy.wsd;

import java.util.List;


public interface WsdMethod {
	List<WsdResult> getMatch(List<Utterance> argUtterances);
}
