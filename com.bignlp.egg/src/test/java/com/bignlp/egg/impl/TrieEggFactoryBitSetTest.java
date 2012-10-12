package com.bignlp.egg.impl;

import com.bignlp.egg.impl.trie.TrieEggFactory;
import com.bignlp.egg.impl.trie.TrieEggNodeBitSetFactory;
import com.bignlp.egg.metrics.InstrumentedEggFactory;

public class TrieEggFactoryBitSetTest extends AbstractEggFactoryTest {

	public TrieEggFactoryBitSetTest() {
		super(new InstrumentedEggFactory<Integer>(new TrieEggFactory<Integer>(
				new TrieEggNodeBitSetFactory<Integer>())));
	}

}
