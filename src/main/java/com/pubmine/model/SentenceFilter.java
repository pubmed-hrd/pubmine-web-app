package com.pubmine.model;

public class SentenceFilter {
	private String query;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	@Override
	public String toString() {
		return "SentenceFilter [query=" + query + "]";
	}
	
}
