package com.bignlp.egg.impl;

import java.io.Serializable;
import java.util.Map;

import com.bignlp.egg.DuplicateEntryException;
import com.bignlp.egg.Egg;

public class MapEgg<V extends Serializable> implements Egg<V> {
	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, V> kvMap;

	public MapEgg(Map<String, V> argKvMap) {
		this.kvMap = argKvMap;
	}

	public V find(CharSequence argCharSequence) {
		return this.kvMap.get(argCharSequence.toString());
	}

	public void insert(CharSequence argCharSequence, V argValue)
			throws DuplicateEntryException {
		this.kvMap.put(argCharSequence.toString(), argValue);
	}

}
