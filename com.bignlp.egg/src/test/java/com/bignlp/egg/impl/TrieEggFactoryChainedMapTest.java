package com.bignlp.egg.impl;

import com.bignlp.egg.impl.trie.TrieEggFactory;
import com.bignlp.egg.impl.trie.TrieEggNodeChainedMapFactory;
import com.bignlp.egg.metrics.InstrumentedEggFactory;

public class TrieEggFactoryChainedMapTest extends AbstractEggFactoryTest {

	public TrieEggFactoryChainedMapTest() {
		super(new InstrumentedEggFactory<Integer>(new TrieEggFactory<Integer>(
				new TrieEggNodeChainedMapFactory<Integer>())));
	}

}
