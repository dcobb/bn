package com.bignlp.egg.impl;

import com.bignlp.egg.metrics.InstrumentedEggFactory;

public class TreeEggFactoryTest extends AbstractEggFactoryTest {

	public TreeEggFactoryTest() {
		super(new InstrumentedEggFactory<Integer>(new TreeEggFactory<Integer>()));
	}

}
