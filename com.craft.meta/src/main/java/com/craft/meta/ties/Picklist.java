package com.craft.meta.ties;

public abstract class Picklist {
	private String name;
	private PicklistType picklistType;
	private boolean allowMultiselect;

	public Picklist() {
		super();
	}

	public Picklist(String argName, PicklistType argPicklistType,
			boolean argAllowMultiselect) {
		super();
		this.name = argName;
		this.picklistType = argPicklistType;
		this.allowMultiselect = argAllowMultiselect;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String argName) {
		this.name = argName;
	}

	public PicklistType getPicklistType() {
		return this.picklistType;
	}

	public void setPicklistType(PicklistType argPicklistType) {
		this.picklistType = argPicklistType;
	}

	public boolean isAllowMultiselect() {
		return this.allowMultiselect;
	}

	public void setAllowMultiselect(boolean argAllowMultiselect) {
		this.allowMultiselect = argAllowMultiselect;
	}

}
