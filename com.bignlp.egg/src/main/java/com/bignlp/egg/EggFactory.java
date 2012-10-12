package com.bignlp.egg;

import java.io.Serializable;

public interface EggFactory<V extends Serializable> {
	Egg<V> newEgg();

	Egg<V> newEgg(Glossary<V> argGlossary);
}
