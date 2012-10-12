package com.bignlp.egg.impl;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

import com.bignlp.egg.Egg;
import com.bignlp.egg.EggDeserializer;
import com.bignlp.egg.EggException;

public class StandardJavaEggDeserializer<V extends Serializable> implements
		EggDeserializer<V> {

	public StandardJavaEggDeserializer() {
	}

	public Egg<V> read(InputStream argStream) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(argStream);
			@SuppressWarnings("unchecked")
			Egg<V> egg = (Egg<V>) ois.readObject();
			return egg;
		} catch (Exception e) {
			throw new EggException("could not read egg to output stream", e);
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (Exception ignore) {
					// ignore
				}
			}
		}
	}

}
