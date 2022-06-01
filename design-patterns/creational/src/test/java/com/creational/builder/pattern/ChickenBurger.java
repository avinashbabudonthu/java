package com.creational.builder.pattern;

public class ChickenBurger extends Burger {

	@Override
	public String name() {
		return "chicken burger";
	}

	@Override
	public double price() {
		return 2.34;
	}

}