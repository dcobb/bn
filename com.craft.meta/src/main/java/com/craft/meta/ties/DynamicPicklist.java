package com.craft.meta.ties;

import java.util.List;

import com.craft.meta.schema.Entity;
import com.craft.meta.schema.Field;

public class DynamicPicklist extends Picklist {
	private Entity sourceEntity;
	private Field displayField;
	private Field submitField;
	private List<Field> groupFields;

	public DynamicPicklist() {
		super();
	}

	public DynamicPicklist(String argName, PicklistType argPicklistType,
			boolean argAllowMultiselect) {
		super(argName, argPicklistType, argAllowMultiselect);
	}

	public DynamicPicklist(Entity argSourceEntity, Field argDisplayField,
			Field argSubmitField) {
		this(argSourceEntity, argDisplayField, argSubmitField, null);
	}

	public DynamicPicklist(Entity argSourceEntity, Field argDisplayField,
			Field argSubmitField, List<Field> argGroupFields) {
		super();
		this.sourceEntity = argSourceEntity;
		this.displayField = argDisplayField;
		this.submitField = argSubmitField;
		this.groupFields = argGroupFields;
	}

	public Entity getSourceEntity() {
		return this.sourceEntity;
	}

	public void setSourceEntity(Entity argSourceEntity) {
		this.sourceEntity = argSourceEntity;
	}

	public Field getDisplayField() {
		return this.displayField;
	}

	public void setDisplayField(Field argDisplayField) {
		this.displayField = argDisplayField;
	}

	public Field getSubmitField() {
		return this.submitField;
	}

	public void setSubmitField(Field argSubmitField) {
		this.submitField = argSubmitField;
	}

	public List<Field> getGroupFields() {
		return this.groupFields;
	}

	public void setGroupFields(List<Field> argGroupFields) {
		this.groupFields = argGroupFields;
	}

}
