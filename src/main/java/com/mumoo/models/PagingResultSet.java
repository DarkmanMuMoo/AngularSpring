package com.mumoo.models;

import java.util.List;

public class PagingResultSet {
	
	private List results;
	private int totalAmount;

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}


	public List getResults() {
		return results;
	}

	public void setResults(List results) {
		this.results = results;
	}


}
