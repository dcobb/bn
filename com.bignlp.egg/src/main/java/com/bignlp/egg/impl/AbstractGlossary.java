package com.bignlp.egg.impl;

import java.io.Serializable;
import java.util.Iterator;

import com.bignlp.egg.Glossary;

public abstract class AbstractGlossary<V extends Serializable> implements
		Glossary<V> {
	public static class DefaultGlossaryEntry<V> implements Glossary.Entry<V> {

		private CharSequence charSequence;
		private V value;

		public DefaultGlossaryEntry(CharSequence argCharSequence, V argValue) {
			this.charSequence = argCharSequence;
			this.value = argValue;
		}

		public CharSequence getCharSequence() {
			return this.charSequence;
		}

		public V getValue() {
			return this.value;
		}

		@Override
		public String toString() {
			return "DefaultGlossaryEntry [charSequence=" + this.charSequence
					+ ", value=" + this.value + "]";
		}

	}

	protected static final Serializable DEFAULT_VALUE = new Integer(7);

	public void close() {

	}

	public Iterator<Glossary.Entry<V>> iterator() {
		return this;
	}

	public void open() {

	}

	public void remove() {
		throw new UnsupportedOperationException(this.getClass()
				+ " does not support remove() method");
	}

	public void reset() {

	}
}
