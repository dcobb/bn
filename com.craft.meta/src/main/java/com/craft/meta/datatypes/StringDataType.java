package com.craft.meta.datatypes;

import java.math.BigInteger;
import java.util.List;

import com.craft.meta.Attribute;

public class StringDataType extends DataType {
	public static final String MAX_LENGTH = "maxLength";
	public static final String MIN_LENGTH = "minLength";
	public static final String SIZE = "size";
	public static final String CASE_SENSISTIVE = "caseSensitive";
	public static final String CASE = "case";
	public static final String FORMAT = "format";
	public static final String REGEX = "regex";
	public static final String TRIM = "trim";
	public static final String ALLOW_EMPTY = "allowEmpty";

	private BigInteger size;
	private BigInteger minLength;
	private BigInteger maxLength;
	private boolean caseSensitive;
	private StringCase stringCase;
	private String format;
	private String regex;
	private boolean trim;

	public StringDataType() {
		super(PrimitiveDataTypes.STRING);
	}

	public StringDataType(int argSize) {
		super(PrimitiveDataTypes.STRING);
	}

	public StringDataType(Attribute... argAttributes) {
		super(PrimitiveDataTypes.STRING, true, null, argAttributes);
	}

	public StringDataType(List<Attribute> argAttributes) {
		super(PrimitiveDataTypes.STRING, true, null, argAttributes);
	}

	/* package */StringDataType(String argName, boolean argPrimitive) {
		super(argName, argPrimitive);
	}

	/* package */StringDataType(String argName, boolean argPrimitive,
			DataType argSuperDataType) {
		super(argName, argPrimitive, argSuperDataType);
	}

	/* package */StringDataType(String argName, boolean argPrimitive,
			DataType argSuperDataType, Attribute... argAttributes) {
		super(argName, argPrimitive, argSuperDataType, argAttributes);
	}

	/* package */StringDataType(String argName, boolean argPrimitive,
			DataType argSuperDataType, List<Attribute> argAttributes) {
		super(argName, argPrimitive, argSuperDataType, argAttributes);
	}

	protected StringDataType(String argName) {
		super(argName, false);
	}

	protected StringDataType(String argName, DataType argSuperDataType) {
		super(argName, false, argSuperDataType);
	}

	protected StringDataType(String argName, DataType argSuperDataType,
			Attribute... argAttributes) {
		super(argName, false, argSuperDataType, argAttributes);
	}

	protected StringDataType(String argName, DataType argSuperDataType,
			List<Attribute> argAttributes) {
		super(argName, false, argSuperDataType, argAttributes);
	}

	public BigInteger getSize() {
		return this.size;
	}

	public void setSize(BigInteger argSize) {
		this.size = argSize;
	}

	public BigInteger getMinLength() {
		return this.minLength;
	}

	public void setMinLength(BigInteger argMinLength) {
		this.minLength = argMinLength;
	}

	public BigInteger getMaxLength() {
		return this.maxLength;
	}

	public void setMaxLength(BigInteger argMaxLength) {
		this.maxLength = argMaxLength;
	}

	public boolean isCaseSensitive() {
		return this.caseSensitive;
	}

	public void setCaseSensitive(boolean argCaseSensitive) {
		this.caseSensitive = argCaseSensitive;
	}

	public StringCase getStringCase() {
		return this.stringCase;
	}

	public void setStringCase(StringCase argStringCase) {
		this.stringCase = argStringCase;
	}

	public String getFormat() {
		return this.format;
	}

	public void setFormat(String argFormat) {
		this.format = argFormat;
	}

	public String getRegex() {
		return this.regex;
	}

	public void setRegex(String argRegex) {
		this.regex = argRegex;
	}

	public boolean isTrim() {
		return this.trim;
	}

	public void setTrim(boolean argTrim) {
		this.trim = argTrim;
	}

}
