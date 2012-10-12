package com.bignlp.egg.impl.trie;

import java.util.Arrays;


public class TrieEggNodeBitSet<V> implements TrieEggNode<V> {
	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private static final int INVALID_INDEX = -1;
	static final char ROOT_NODE_CHAR = (char) -2;
	private char c;
	private EggBitSet nextNodeBitset;
	private TrieEggNode<V>[] nextNodes;
	private V value;

	protected TrieEggNodeBitSet() {
		this.c = (char) INVALID_INDEX;
		this.nextNodeBitset = null;
		this.nextNodes = null;
		this.value = null;
	}

	public TrieEggNodeBitSet(char c, V argValue) {
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
				if (this.nextNodes != null && this.nextNodes.length > 0) {
					int nextNodesCurrentLength = this.nextNodes.length;
					TrieEggNode<V>[] newNextNodes = new TrieEggNode[nextNodesCurrentLength + 1];
					System.arraycopy(this.nextNodes, 0, newNextNodes, 0,
							nextNodesCurrentLength);
					newNextNodes[nextNodesCurrentLength] = argNext;
					this.nextNodes = newNextNodes;
				} else {
					this.nextNodes = new TrieEggNodeBitSet[1];
					this.nextNodes[0] = argNext;
				}
				if (this.nextNodeBitset == null) {
					this.nextNodeBitset = new EggBitSet();
				}
				this.nextNodeBitset.set(cIndex);
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

	public TrieEggNode<V> getNext(char c) {
		int nextNodeIndex = this.getNextNodeIndex(c);
		return nextNodeIndex != INVALID_INDEX
				&& nextNodeIndex < this.nextNodes.length ? this.nextNodes[nextNodeIndex]
				: null;
	}

	private int getNextNodeIndex(char c) {
		if (this.nextNodeBitset != null) {
			int cIndex = SymbolTable.DEFAULT_SYMBOL_TABLE.lookupIndexOf(c);
			if (cIndex != INVALID_INDEX
					&& cIndex < this.nextNodeBitset.length()) {
				if (this.nextNodeBitset.get(cIndex)) {
					int result = getWhichBit(cIndex);
					return result;
				}
			}
		}
		return INVALID_INDEX;
	}

	public V getValue() {
		return this.value;
	}

	private int getWhichBit(int argCIndex) {
		int result = INVALID_INDEX;
		for (int i = 0; i <= argCIndex && i < this.nextNodeBitset.length(); ++i) {
			if (this.nextNodeBitset.get(i)) {
				++result;
			}
		}
		return result;
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
