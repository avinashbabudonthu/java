package com.creational.builder.pattern;

public class Coke extends Drink {

	@Override
	public String name() {
		return "coke";
	}

	@Override
	public double price() {
		return 0.5;
	}

}