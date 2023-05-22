package com.creational.builder.pattern;

public class Pepsi extends Drink {

	@Override
	public String name() {
		return "pepsi";
	}

	@Override
	public double price() {
		return 0.5;
	}

}