package com.craft.meta.ties;

public class QueryBasedPicklist extends Picklist {
	private String query;

	public QueryBasedPicklist() {
		super();
	}

	public QueryBasedPicklist(String argName, PicklistType argPicklistType,
			boolean argAllowMultiselect) {
		super(argName, argPicklistType, argAllowMultiselect);
	}

	
	public QueryBasedPicklist(String argName, String argQuery, boolean argAllowMultiselect) {
		super(argName, PicklistType.QUERY_BACKED_PICKLIST, argAllowMultiselect);
		this.query = argQuery;
	}

	public String getQuery() {
		return this.query;
	}

	public void setQuery(String argQuery) {
		this.query = argQuery;
	}

}
