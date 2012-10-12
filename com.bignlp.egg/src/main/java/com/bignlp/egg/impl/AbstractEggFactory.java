package com.bignlp.egg.impl;

import java.io.Serializable;

import com.bignlp.egg.Egg;
import com.bignlp.egg.EggFactory;
import com.bignlp.egg.Glossary;

public abstract class AbstractEggFactory<V extends Serializable> implements
		EggFactory<V> {

	public Egg<V> newEgg(Glossary<V> argGlossary) {
		if (argGlossary != null) {
			Egg<V> egg = this.newEgg();
			for (Glossary.Entry<V> entry : argGlossary) {
				if (entry != null && entry.getCharSequence().length() > 0) {
					egg.insert(entry.getCharSequence(), entry.getValue());
				}
			}
			return egg;
		}
		throw new IllegalArgumentException(
				"argGlossary cannot be null or empty");
	}

}
