package com.behavioral.command.pattern;

public class Stock {

	protected String stockName;
	protected Integer quantity;

	public Stock(String stockName, Integer quanity) {
		this.stockName = stockName;
		this.quantity = quanity;
	}

	public void buy() {
		System.out.println(String.format("buying %d number of %s stocks", quantity, stockName));
	}

	public void sell() {
		System.out.println(String.format("selling %d number of %s stocks", quantity, stockName));
	}
}