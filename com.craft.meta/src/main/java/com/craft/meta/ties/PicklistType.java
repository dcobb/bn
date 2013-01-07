package com.craft.meta.ties;

import java.util.LinkedHashMap;
import java.util.Map;

public class PicklistType {
	public static final PicklistType STATIC = new PicklistType("static");
	public static final PicklistType DYNAMIC = new PicklistType("dynamic");
	public static final PicklistType QUERY_BACKED_PICKLIST = new PicklistType(
			"query");

	public static final Map<String, PicklistType> NAME_VS_PICKLIST_TYPE_MAP = createNameVsPicklistTypeMap();

	private String name;

	public PicklistType() {
		super();
	}

	private static Map<String, PicklistType> createNameVsPicklistTypeMap() {
		Map<String, PicklistType> temp = new LinkedHashMap<>();
		temp.put(STATIC.getName(), STATIC);
		temp.put(DYNAMIC.getName(), DYNAMIC);
		temp.put(QUERY_BACKED_PICKLIST.getName(), QUERY_BACKED_PICKLIST);
		return temp;
	}

	public PicklistType(String argName) {
		super();
		this.name = argName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String argName) {
		this.name = argName;
	}

}
