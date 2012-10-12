package com.bignlp.egg.impl;

import java.io.Serializable;

import com.bignlp.egg.Egg;
import com.bignlp.egg.impl.trie.patricia.CharSequenceKeyAnalyzer;
import com.bignlp.egg.impl.trie.patricia.PatriciaTrie;

public class PatriciaTrieEggFactory<V extends Serializable> extends
		AbstractEggFactory<V> {

	public Egg<V> newEgg() {
		return new MapEgg<V>(new PatriciaTrie<String, V>(new CharSequenceKeyAnalyzer()));
	}
}
