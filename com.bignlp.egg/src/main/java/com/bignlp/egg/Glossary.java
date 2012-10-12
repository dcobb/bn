package com.bignlp.egg;

import java.util.Iterator;

public interface Glossary<V> extends Iterator<Glossary.Entry<V>>,
		Iterable<Glossary.Entry<V>> {
	interface Entry<V> {
		CharSequence getCharSequence();

		V getValue();
	}

	void close();

	void open();

	void reset();

}
