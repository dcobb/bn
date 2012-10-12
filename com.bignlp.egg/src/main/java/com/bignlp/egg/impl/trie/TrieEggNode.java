package com.bignlp.egg.impl.trie;

import java.io.Serializable;

public interface TrieEggNode<V> extends Serializable {
	void addNext(TrieEggNode<V> argEggNode);

	char getChar();

	TrieEggNode<V> getNext(char c);

	V getValue();

	void setChar(char c);

	void setValue(V argValue);

}
