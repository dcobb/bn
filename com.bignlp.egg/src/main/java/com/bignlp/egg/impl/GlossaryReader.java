package com.bignlp.egg.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;

import com.bignlp.egg.EggException;
import com.bignlp.egg.Glossary;

public class GlossaryReader<V extends Serializable> extends AbstractGlossary<V> {
	private static class FileGlossaryEntry<V> implements Glossary.Entry<V> {

		private CharSequence charSequence;
		private V value;

		public FileGlossaryEntry(CharSequence argCharSequence, V argValue) {
			this.charSequence = argCharSequence;
			this.value = argValue;
		}

		public CharSequence getCharSequence() {
			return this.charSequence;
		}

		public V getValue() {
			return this.value;
		}

	}

	private BufferedReader bufferedReader;
	private Entry<V> current;

	private boolean opened;

	public GlossaryReader(Reader argReader) {
		if (argReader != null) {
			if (argReader instanceof BufferedReader) {
				this.bufferedReader = (BufferedReader) argReader;
			} else {
				this.bufferedReader = new BufferedReader(argReader);
			}
		}
	}

	public void close() {
		if (this.bufferedReader != null) {
			try {
				this.bufferedReader.close();
			} catch (Exception ignore) {
				// ignore
			}
		}
	}

	public boolean hasNext() {
		if (!opened) {
			this.open();
		}
		return this.current != null;
	}

	public Entry<V> next() {
		Entry<V> result = this.current;
		try {
			this.readLine();
		} catch (IOException e) {
			throw new EggException("Could not read from reader", e);
		}
		return result;
	}

	public void open() {
		if (!opened) {
			try {
				this.readLine();
				this.opened = true;
			} catch (Exception e) {
				throw new EggException("could not read from reader", e);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void readLine() throws IOException {
		String line = this.bufferedReader.readLine();
		if (line != null) {
			this.current = new FileGlossaryEntry<V>(line, (V) DEFAULT_VALUE);
		} else {
			this.current = null;
		}
	}

	public void reset() {
		opened = false;
	}
}
