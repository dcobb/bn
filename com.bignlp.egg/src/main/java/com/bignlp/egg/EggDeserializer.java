package com.bignlp.egg;

import java.io.InputStream;
import java.io.Serializable;

public interface EggDeserializer<V extends Serializable> {
	Egg<V> read(InputStream argStream);
}
