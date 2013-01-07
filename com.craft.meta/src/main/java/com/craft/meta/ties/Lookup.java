package com.craft.meta.ties;

import java.util.List;

import com.craft.meta.schema.Entity;
import com.craft.meta.schema.Field;

public class Lookup {
	String name;
	Entity lookedUpEntity;
	Field lookedUpField;
	List<Field> lookupResultFields;
}
