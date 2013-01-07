package com.craft.meta.schema;

import java.util.Set;

public class Entity {
	String name;
	boolean abstractEntity;
	Entity superEntity;
	Set<Field> fields;
	Set<Relationship> relationships;
}
