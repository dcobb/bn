package com.bignlp.egg.impl;

import com.bignlp.egg.metrics.InstrumentedEggFactory;

public class HashedEggFactoryTest extends AbstractEggFactoryTest {

	public HashedEggFactoryTest() {
		super(new InstrumentedEggFactory<Integer>(new HashedEggFactory<Integer>()));
	}

}
