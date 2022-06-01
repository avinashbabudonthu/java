package com.creational.builder.pattern;

public class VegBurger extends Burger {

	@Override
	public String name() {
		return "veg burger";
	}

	@Override
	public double price() {
		return 1.23;
	}

}
