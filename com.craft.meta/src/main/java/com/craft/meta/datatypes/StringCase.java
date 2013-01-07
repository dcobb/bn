package com.craft.meta.datatypes;

public class StringCase {
	public static final StringCase LOWER = new StringCase("lower");
	public static final StringCase UPPER = new StringCase("upper");
	public static final StringCase CAMEL = new StringCase("camel");
	public static final StringCase SNAKE = new StringCase("snake");

	private String name;

	public StringCase() {
		super();
	}

	public StringCase(String argName) {
		super();
		this.name = argName;
	}

}
