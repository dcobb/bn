package com.bignlp.egg.metrics;

import com.bignlp.egg.impl.trie.TrieEggNode;
import com.yammer.metrics.core.Timer;
import com.yammer.metrics.core.TimerContext;

public class InstrumentedEggNode<V> implements TrieEggNode<V> {
	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private TrieEggNode<V> delegate;

	private transient Timer timerAddNext;
	private transient Timer timerGetNext;

	public InstrumentedEggNode(TrieEggNode<V> argEggNode) {
		this.delegate = argEggNode;
	}

	public void addNext(TrieEggNode<V> argEggNode) {
		TimerContext timerContext = this.timerAddNext.time();
		try {
			this.delegate.addNext(argEggNode);
		} finally {
			timerContext.stop();
		}

	}

	public char getChar() {
		return this.delegate.getChar();
	}

	public TrieEggNode<V> getNext(char argC) {
		TimerContext timerContext = this.timerGetNext.time();
		try {
			TrieEggNode<V> next = this.delegate.getNext(argC);
			return next;
		} finally {
			timerContext.stop();
		}
	}

	public V getValue() {
		return this.delegate.getValue();
	}

	public void setChar(char argC) {
		this.delegate.setChar(argC);
	}

	public void setValue(V argValue) {
		this.delegate.setValue(argValue);
	}

}
