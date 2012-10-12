package com.bignlp.egg.impl;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import com.bignlp.egg.Egg;
import com.bignlp.egg.EggException;
import com.bignlp.egg.EggSerializer;

public class StandardJavaEggSerializer<V extends Serializable> implements
		EggSerializer<V> {

	public StandardJavaEggSerializer() {
	}

	public void write(Egg<V> argEgg, OutputStream argStream) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(argStream);
			oos.writeObject(argEgg);
		} catch (Exception e) {
			throw new EggException("could not write egg to output stream", e);
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (Exception ignore) {
					// ignore
				}
			}
		}
	}

}
