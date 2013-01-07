package com.craft.meta;

public class Attribute {
	private String name;
	private String value;

	public Attribute() {
		super();
	}

	public Attribute(String argName, String argValue) {
		super();
		this.name = argName;
		this.value = argValue;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String argName) {
		this.name = argName;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String argValue) {
		this.value = argValue;
	}

}
