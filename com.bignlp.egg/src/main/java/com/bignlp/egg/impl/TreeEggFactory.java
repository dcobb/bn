package com.bignlp.egg.impl;

import java.io.Serializable;
import java.util.TreeMap;

import com.bignlp.egg.Egg;

public class TreeEggFactory<V extends Serializable> extends
		AbstractEggFactory<V> {

	public Egg<V> newEgg() {
		return new MapEgg<V>(new TreeMap<String, V>());
	}
}
