package com.creational.factory.pattern;

import org.junit.Test;

public class FactoryPattern {

	@Test
	public void execute() {
		ShapeFactory shapeFactory = new ShapeFactory();

		Shape circle = shapeFactory.getShape("circle");
		Shape square = shapeFactory.getShape("square");
		Shape rectangle = shapeFactory.getShape("rectangle");

		circle.draw();
		square.draw();
		rectangle.draw();
	}
}