package com.bignlp.egg.impl.trie;

import java.util.Arrays;

public class TrieEggNodeSparseArray<V> implements TrieEggNode<V> {
	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private static final int INVALID_INDEX = -1;
	static final char ROOT_NODE_CHAR = (char) -2;
	private char c;
	private TrieEggNode<V>[] nextNodes;
	private V value;

	protected TrieEggNodeSparseArray() {
		this.c = (char) INVALID_INDEX;
		this.nextNodes = null;
		this.value = null;
	}

	public TrieEggNodeSparseArray(char c, V argValue) {
		this();
		this.setChar(c);
		this.value = argValue;
	}

	@SuppressWarnings("unchecked")
	public void addNext(TrieEggNode<V> argNext) {
		if (argNext != null) {
			int cIndex = SymbolTable.DEFAULT_SYMBOL_TABLE.lookupIndexOf(argNext
					.getChar());
			if (cIndex >= 0) {
				if (this.nextNodes == null) {
					this.nextNodes = new TrieEggNode[cIndex + 1];
				} else {
					if (cIndex >= this.nextNodes.length) {
						TrieEggNode<V>[] newNextNodes = new TrieEggNode[cIndex + 1];
						System.arraycopy(this.nextNodes, 0, newNextNodes, 0,
								this.nextNodes.length);
						this.nextNodes = newNextNodes;
					}
				}
				this.nextNodes[cIndex] = argNext;
			} else {
				throw new IllegalArgumentException(
						"Invalid charDomainIndex for argNewNode: " + cIndex);
			}
		} else {
			throw new IllegalArgumentException(
					"argNext cannot be null or empty");
		}
	}

	public char getChar() {
		return this.c;
	}

	public TrieEggNode<V> getNext(char argC) {
		int nextNodeIndex = SymbolTable.DEFAULT_SYMBOL_TABLE
				.lookupIndexOf(argC);
		return nextNodeIndex != INVALID_INDEX && this.nextNodes != null
				&& nextNodeIndex < this.nextNodes.length ? this.nextNodes[nextNodeIndex]
				: null;
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
		return this.getChar() + " nextNodes=" + Arrays.toString(this.nextNodes);
	}

}
