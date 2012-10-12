package com.bignlp.egg.impl;

import com.bignlp.egg.impl.trie.TrieEggFactory;
import com.bignlp.egg.impl.trie.TrieEggNodeSparseArrayFactory;
import com.bignlp.egg.metrics.InstrumentedEggFactory;

public class TrieEggFactorySparseArrayTest extends AbstractEggFactoryTest {

	public TrieEggFactorySparseArrayTest() {
		super(new InstrumentedEggFactory<Integer>(new TrieEggFactory<Integer>(
				new TrieEggNodeSparseArrayFactory<Integer>())));
	}

}
