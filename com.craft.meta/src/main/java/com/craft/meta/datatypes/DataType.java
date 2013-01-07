package com.craft.meta.datatypes;

import java.util.Arrays;
import java.util.List;

import com.craft.meta.Attribute;

public class DataType {
	public static final String DEFAULT_LABEL = "defaultLabel";
	
	private String name;
	private boolean primitive;
	private DataType superDataType;
	private List<Attribute> attributes;

	public DataType() {
		super();
	}

	public DataType(String argName) {
		this(argName, false, null, (List<Attribute>) null);
	}

	public DataType(String argName, boolean argPrimitive) {
		this(argName, argPrimitive, null, (List<Attribute>) null);
	}

	public DataType(String argName, boolean argPrimitive,
			DataType argSuperDataType) {
		this(argName, argPrimitive, argSuperDataType, (List<Attribute>) null);
	}

	public DataType(String argName, boolean argPrimitive,
			DataType argSuperDataType, List<Attribute> argAttributes) {
		super();
		this.name = argName;
		this.primitive = argPrimitive;
		this.superDataType = argSuperDataType;
		this.attributes = argAttributes;
	}

	public DataType(String argName, boolean argPrimitive,
			DataType argSuperDataType, Attribute... argAttributes) {
		this(argName, argPrimitive, argSuperDataType,
				(argAttributes != null ? Arrays.asList(argAttributes) : null));
	}

	public String getName() {
		return this.name;
	}

	public void setName(String argName) {
		this.name = argName;
	}

	public boolean isPrimitive() {
		return this.primitive;
	}

	public void setPrimitive(boolean argPrimitive) {
		this.primitive = argPrimitive;
	}

	public DataType getSuperDataType() {
		return this.superDataType;
	}

	public void setSuperDataType(DataType argSuperDataType) {
		this.superDataType = argSuperDataType;
	}

	public List<Attribute> getAttributes() {
		return this.attributes;
	}

	public void setAttributes(List<Attribute> argAttributes) {
		this.attributes = argAttributes;
	}

}
