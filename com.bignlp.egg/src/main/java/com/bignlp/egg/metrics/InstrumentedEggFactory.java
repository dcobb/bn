package com.bignlp.egg.metrics;

import java.io.Serializable;

import com.bignlp.egg.Egg;
import com.bignlp.egg.EggFactory;
import com.bignlp.egg.impl.AbstractEggFactory;

public class InstrumentedEggFactory<V extends Serializable> extends
		AbstractEggFactory<V> {
	private EggFactory<V> delegate;

	public InstrumentedEggFactory(EggFactory<V> argDelegate) {
		this.delegate = argDelegate;
	}

	public Egg<V> newEgg() {
		return new InstrumentedEgg<V>(this.delegate.newEgg());
	}

}
