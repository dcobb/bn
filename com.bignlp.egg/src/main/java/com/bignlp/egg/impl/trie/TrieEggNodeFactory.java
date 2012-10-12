package com.bignlp.egg.impl.trie;

import java.io.Serializable;

public interface TrieEggNodeFactory<V> extends Serializable {
	TrieEggNode<V> newEggNode(char c, V argValue);

	TrieEggNode<V> newRootEggNode(V argValue);

}
