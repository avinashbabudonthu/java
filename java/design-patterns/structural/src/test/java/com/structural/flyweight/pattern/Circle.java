package com.structural.flyweight.pattern;

public class Circle implements Shape {

	private String color;

	public Circle(String color) {
		this.color = color;
	}

	@Override
	public void draw() {
		System.out.println(this.color + " circle draw method");
	}

}