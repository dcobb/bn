package com.bignlp.egg.impl;

import com.bignlp.egg.metrics.InstrumentedEggFactory;

public class PatriciaTrieEggFactoryTest extends AbstractEggFactoryTest {

	public PatriciaTrieEggFactoryTest() {
		super(new InstrumentedEggFactory<Integer>(new HashedEggFactory<Integer>()));
	}

}
