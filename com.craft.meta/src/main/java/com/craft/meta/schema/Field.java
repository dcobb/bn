package com.craft.meta.schema;

import com.craft.meta.datatypes.DataType;
import com.craft.meta.ties.Lookup;
import com.craft.meta.ties.Picklist;


public class Field {
	String name;
	DataType dataType;
	boolean required;
	boolean computed;
	Formula formula;
	Lookup lookup;
	Picklist picklist;
	int size;
	int decimalDigits;
}
