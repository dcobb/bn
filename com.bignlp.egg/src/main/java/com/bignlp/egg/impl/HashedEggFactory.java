package com.bignlp.egg.impl;

import java.io.Serializable;
import java.util.HashMap;

import com.bignlp.egg.Egg;

public class HashedEggFactory<V extends Serializable> extends
		AbstractEggFactory<V> {

	public Egg<V> newEgg() {
		return new MapEgg<V>(new HashMap<String, V>());
	}
}
