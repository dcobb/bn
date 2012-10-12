package com.bignlp.egg.impl.trie;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
	public static class Entry {
		private int begin;
		private int end;
		private int indexOffset;
		private int length;
		private Entry next;

		public Entry(int argBegin, int argEnd) {
			if (argEnd >= argBegin) {
				if (argBegin >= 0) {
					if (argEnd >= 0) {
						this.begin = argBegin;
						this.end = argEnd;
						this.length = this.end - this.begin + 1;
						this.indexOffset = 0;
					} else {
						throw new IllegalArgumentException(
								"argEnd must be a non-negative number");
					}
				} else {
					throw new IllegalArgumentException(
							"argBegin must be a non-negative number");
				}
			} else {
				throw new IllegalArgumentException(
						"argBegin must be less than or equal to argEnd");
			}
		}

		public Entry link(Entry argNext) {
			if (argNext != null) {
				argNext.indexOffset = this.indexOffset + this.length;
				if (this.next == null) {
					this.next = argNext;
					return this.next;
				} else {
					throw new IllegalStateException("next is already set");
				}
			} else {
				throw new IllegalArgumentException("argNext cannot be null");
			}
		}
	}
	private static final Entry BASE_36_SYMBOL_TABLE_ROOT_ENTRY = initializeAngGetRootEntry();
	public static final SymbolTable DEFAULT_SYMBOL_TABLE = new SymbolTable();
	private static Entry initializeAngGetRootEntry() {
		Entry firstCharBlock = new Entry('0', '9');
		firstCharBlock.link(new Entry('a', 'z'));
		return firstCharBlock;
	}
	public static void main(String[] args) {
		System.out.println("a=" + DEFAULT_SYMBOL_TABLE.getIndexOf('a'));
		System.out.println("e=" + DEFAULT_SYMBOL_TABLE.getIndexOf('e'));
		System.out.println("i=" + DEFAULT_SYMBOL_TABLE.getIndexOf('i'));
		System.out.println("o=" + DEFAULT_SYMBOL_TABLE.getIndexOf('o'));
		System.out.println("u=" + DEFAULT_SYMBOL_TABLE.getIndexOf('u'));
		System.out.println("7=" + DEFAULT_SYMBOL_TABLE.getIndexOf('7'));
		System.out.println("9=" + DEFAULT_SYMBOL_TABLE.getIndexOf('9'));
		for (int i = 0; i < DEFAULT_SYMBOL_TABLE.getSize(); i++) {
			System.out.println("char at " + i + " = "
					+ DEFAULT_SYMBOL_TABLE.charAt(i));
		}
	}
	private char[] chars;

	private Map<Character, Integer> charVsIndexMap;

	private Entry root;

	private int size;

	public SymbolTable() {
		this(BASE_36_SYMBOL_TABLE_ROOT_ENTRY);
	}

	public SymbolTable(Entry argRoot) {
		this.root = argRoot;
		this.size = computeSize();
		buildDenormalizedLookups();
	}

	private void buildDenormalizedLookups() {
		if (this.root != null) {
			this.chars = new char[this.size];
			this.charVsIndexMap = new HashMap<Character, Integer>(this.size);
			int resultIndex = 0;
			Entry current = this.root;
			while (current != null) {
				int currentChar = current.begin;
				for (int i = 0; i < current.length; ++i, ++currentChar, ++resultIndex) {
					this.chars[resultIndex] = (char) currentChar;
					this.charVsIndexMap.put((char) currentChar, resultIndex);
				}
				current = current.next;
			}
		} else {
			throw new IllegalStateException("Char Blocks are not initialized");
		}
	}

	public char charAt(int argIndex) {
		if (this.chars != null) {
			return this.chars[argIndex];
		}
		throw new IllegalStateException("Chars not initialized");
	}

	private int computeSize() {
		if (this.root != null) {
			int result = 0;
			Entry next = this.root;
			while (next != null) {
				result = result + next.length;
				next = next.next;
			}
			return result;
		}
		throw new IllegalStateException("Char Blocks are not initialized");
	}

	public int getIndexOf(char c) {
		if (this.root != null) {
			Entry current = this.root;
			while (current != null) {
				if (c >= current.begin && c <= current.end) {
					return current.indexOffset + c - current.begin;
				}
				current = current.next;
			}
			return -1;
		}
		throw new IllegalStateException("Char Blocks are not initialized");
	}

	public int getSize() {
		return this.size;
	}

	public int lookupIndexOf(char c) {
		Integer index = this.charVsIndexMap.get(c);
		return index != null ? index : -1;
	}

}