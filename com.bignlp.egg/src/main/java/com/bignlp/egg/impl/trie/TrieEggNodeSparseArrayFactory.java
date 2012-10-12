package com.bignlp.egg.impl.trie;

public class TrieEggNodeSparseArrayFactory<V> implements TrieEggNodeFactory<V> {

	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public TrieEggNode<V> newEggNode(char argC, V argValue) {
		return new TrieEggNodeSparseArray<V>(argC, argValue);
	}

	public TrieEggNode<V> newRootEggNode(V argValue) {
		return new TrieEggNodeSparseArray<V>(TrieEggNodeBitSet.ROOT_NODE_CHAR,
				argValue);
	}

}
