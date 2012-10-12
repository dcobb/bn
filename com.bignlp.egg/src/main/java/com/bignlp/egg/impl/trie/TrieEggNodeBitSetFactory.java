package com.bignlp.egg.impl.trie;

public class TrieEggNodeBitSetFactory<V> implements TrieEggNodeFactory<V> {

	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public TrieEggNode<V> newEggNode(char argC, V argValue) {
		return new TrieEggNodeBitSet<V>(argC, argValue);
	}

	public TrieEggNode<V> newRootEggNode(V argValue) {
		return new TrieEggNodeBitSet<V>(TrieEggNodeBitSet.ROOT_NODE_CHAR,
				argValue);
	}

}
