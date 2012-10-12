package com.bignlp.egg.impl.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieEggNodeChainedMap<V> implements TrieEggNode<V> {
	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private static final int INVALID_INDEX = -1;
	static final char ROOT_NODE_CHAR = (char) -2;
	private char c;
	private Map<Character, TrieEggNode<V>> nextNodes;
	private V value;

	protected TrieEggNodeChainedMap() {
		this.c = (char) INVALID_INDEX;
		this.nextNodes = null;
		this.value = null;
	}

	public TrieEggNodeChainedMap(char c, V argValue) {
		this();
		this.setChar(c);
		this.nextNodes = new HashMap<Character, TrieEggNode<V>>(5, (float) 0.8);
		this.value = argValue;
	}

	public void addNext(TrieEggNode<V> argNext) {
		if (argNext != null) {
			this.nextNodes.put(argNext.getChar(), argNext);
		} else {
			throw new IllegalArgumentException(
					"argNext cannot be null or empty");
		}
	}

	public char getChar() {
		return this.c;
	}

	public TrieEggNode<V> getNext(char argC) {
		return this.nextNodes.get(argC);
	}

	public V getValue() {
		return this.value;
	}

	public void setChar(char argChar) {
		if (argChar != ROOT_NODE_CHAR) {
			int cIndex = SymbolTable.DEFAULT_SYMBOL_TABLE
					.lookupIndexOf(argChar);
			if (cIndex == INVALID_INDEX) {
				throw new IllegalArgumentException(
						"argChar is not in the range of CharDomain");
			}
		}
		this.c = argChar;
	}

	public void setValue(V argValue) {
		this.value = argValue;
	}

	@Override
	public String toString() {
		return toStringFullLength();
	}

	public String toStringFullLength() {
		return this.getChar() + " nextNodes=" + this.nextNodes;
	}

}
