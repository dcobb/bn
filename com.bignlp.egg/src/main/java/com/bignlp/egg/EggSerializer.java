package com.bignlp.egg;

import java.io.OutputStream;
import java.io.Serializable;

public interface EggSerializer<V extends Serializable> {
	void write(Egg<V> argEgg, OutputStream argStream);
}
