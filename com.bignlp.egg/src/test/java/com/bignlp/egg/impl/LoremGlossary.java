package com.bignlp.egg.impl;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

import net._01001111.text.LoremIpsum;

public class LoremGlossary<V extends Serializable> extends AbstractGlossary<V> {

	private LoremIpsum lorem;
	private AtomicLong maxWords;

	public LoremGlossary() {
		this(Long.MAX_VALUE);
	}

	public LoremGlossary(long argMaxWords) {
		this.lorem = new LoremIpsum();
		this.maxWords = new AtomicLong(argMaxWords);
	}

	public boolean hasNext() {
		return this.maxWords.get() > 0;
	}

	@SuppressWarnings("unchecked")
	public com.bignlp.egg.Glossary.Entry<V> next() {
		this.maxWords.decrementAndGet();
		return new AbstractGlossary.DefaultGlossaryEntry<V>(lorem.randomWord(),
				(V) AbstractGlossary.DEFAULT_VALUE);
	}

}
