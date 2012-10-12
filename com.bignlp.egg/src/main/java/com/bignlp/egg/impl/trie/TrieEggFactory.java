package com.bignlp.egg.impl.trie;

import java.io.Serializable;

import com.bignlp.egg.Egg;
import com.bignlp.egg.impl.AbstractEggFactory;

public class TrieEggFactory<V extends Serializable> extends
		AbstractEggFactory<V> {
	private TrieEggNodeFactory<V> trieEggNodeFactory;

	public TrieEggFactory(TrieEggNodeFactory<V> argEggNodeFactory) {
		super();
		this.setTrieEggNodeFactory(argEggNodeFactory);
	}

	public Egg<V> newEgg() {
		return new TrieEgg<V>(this.getTrieEggNodeFactory());
	}

	public TrieEggNodeFactory<V> getTrieEggNodeFactory() {
		return trieEggNodeFactory;
	}

	public void setTrieEggNodeFactory(TrieEggNodeFactory<V> trieEggNodeFactory) {
		this.trieEggNodeFactory = trieEggNodeFactory;
	}

}
