package com.bignlp.egg.impl;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class RandomEnglishGlossary<V extends Serializable> extends
		AbstractGlossary<V> {

	private RandomEnglishWordGenerator lorem;
	private AtomicLong maxWords;

	public RandomEnglishGlossary() {
		this(Long.MAX_VALUE);
	}

	public RandomEnglishGlossary(long argMaxWords) {
		this.lorem = new RandomEnglishWordGenerator(20);
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

	public static class RandomEnglishWordGenerator {
		private static final String CONSONENTS = "bcdfghjklmnpqrstvwxz";
		private static final String VOWELS = "aeiouy";
		private static final int CONSONENTS_COUNT = CONSONENTS.length();
		private static final int VOWELS_COUNT = VOWELS.length();
		private int maxLetters;
		private Random random;

		public RandomEnglishWordGenerator(int argMaxletters) {
			super();
			this.maxLetters = argMaxletters;
			this.random = new SecureRandom();
		}

		public String randomWord() {
			int maxLetterCount = this.random.nextInt(this.maxLetters - 1);
			StringBuilder sb = new StringBuilder(maxLetterCount);
			for (int i = 0; i < maxLetterCount; ++i) {
				int consIndex = this.random.nextInt(CONSONENTS_COUNT - 1);
				int vowelIndex = this.random.nextInt(VOWELS_COUNT - 1);
				sb.append(CONSONENTS.charAt(consIndex)).append(
						VOWELS.charAt(vowelIndex));
			}
			return sb.toString();
		}
	}

}
