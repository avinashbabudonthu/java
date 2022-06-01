package com.structural.bridge.pattern;

public class Circle extends Shape {

	private int radius;

	public Circle(int radius, DrawAPI drawApi) {
		super(drawApi);
		this.radius = radius;
	}

	@Override
	public void draw() {
		drawAPI.drawCircle(radius);
	}

}
