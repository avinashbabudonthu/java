package com.behavioral.pattern.nullobject;

public class App {

	public static void main(String[] args) {
		CustomerFactory customerFactory = new CustomerFactory();
		System.out.println(customerFactory.getCustomer("jack"));
		System.out.println(customerFactory.getCustomer("olaf"));
	}
}
