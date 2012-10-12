package com.bignlp.egg.impl.trie;

import java.io.Serializable;
import java.util.BitSet;


public class EggBitSet implements Serializable {

	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private BitSet bitSet;

	public EggBitSet() {
		this.bitSet = new BitSet(SymbolTable.DEFAULT_SYMBOL_TABLE.getSize());
	}

	public boolean get(int argCIndex) {
		return this.bitSet.get(argCIndex);
	}

	public int length() {
		return SymbolTable.DEFAULT_SYMBOL_TABLE.getSize();
	}

	public void set(int argCharDomainIndex) {
		this.bitSet.set(argCharDomainIndex);
	}

}
