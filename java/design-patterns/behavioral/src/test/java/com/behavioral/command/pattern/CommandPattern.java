package com.behavioral.command.pattern;

import org.junit.Test;

public class CommandPattern {

	@Test
	public void execute() {
		Stock stock1 = new Stock("stock1", 10);
		BuyStock buyStock = new BuyStock(stock1);
		SellStock sellStock = new SellStock(stock1);

		Broker broker = new Broker();
		broker.saveOrder(sellStock);
		broker.saveOrder(buyStock);

		broker.placeOrders();

		System.out.println("----------");

		Stock stock2 = new Stock("stock2", 20);
		BuyStock buyStock2 = new BuyStock(stock2);
		SellStock sellStock2 = new SellStock(stock2);

		Broker broker2 = new Broker();
		broker2.saveOrder(sellStock2);
		broker2.saveOrder(buyStock2);

		broker2.placeOrders();
	}
}