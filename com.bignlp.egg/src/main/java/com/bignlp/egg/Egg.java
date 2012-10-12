package com.bignlp.egg;

import java.io.Serializable;

public interface Egg<V extends Serializable> extends Serializable {

	V find(CharSequence argCharSequence);

	void insert(CharSequence argCharSequence, V argValue)
			throws DuplicateEntryException;

}
