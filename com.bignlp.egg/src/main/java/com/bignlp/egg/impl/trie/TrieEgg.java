package com.bignlp.egg.impl.trie;

import java.io.Serializable;

import com.bignlp.egg.DuplicateEntryException;
import com.bignlp.egg.Egg;

public class TrieEgg<V extends Serializable> implements Egg<V> {
	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private TrieEggNodeFactory<V> factory;
	private TrieEggNode<V> root;

	public TrieEgg(TrieEggNodeFactory<V> argEggNodeFactory) {
		this.factory = argEggNodeFactory;
		this.root = this.factory.newRootEggNode(null);
	}

	public V find(CharSequence argCharSequence) {
		TrieEggNode<V> current = root;
		TrieEggNode<V> match = null;
		for (int i = 0; current != null && i < argCharSequence.length(); ++i) {
			if (i < argCharSequence.length()) {
				char c = argCharSequence.charAt(i);
				match = current.getNext(c);
				current = match;
			}
		}
		return match != null ? match.getValue() : null;
	}

	public TrieEggNodeFactory<V> getEggNodeFactory() {
		return this.factory;
	}

	public void insert(CharSequence argCharSequence, V argValue)
			throws DuplicateEntryException {
		TrieEggNode<V> current = root;
		boolean buildingNewBranch = false;
		for (int i = 0; current != null && i < argCharSequence.length(); ++i) {
			char c = argCharSequence.charAt(i);
			TrieEggNode<V> match = !buildingNewBranch ? current.getNext(c)
					: null;
			if (match != null) {
				current = match;
			} else {
				TrieEggNode<V> newNode = this.getEggNodeFactory().newEggNode(c,
						argValue);
				current.addNext(newNode);
				current = newNode;
				buildingNewBranch = true;
			}
		}
		if (!buildingNewBranch) {
			throw new DuplicateEntryException("duplicate entry: "
					+ argCharSequence);
		}
		if (current != null) {
			current.setValue(argValue);
		}
	}

	public void setEggNodeFactory(TrieEggNodeFactory<V> argEggNodeFactory) {
		this.factory = argEggNodeFactory;
	}
}
