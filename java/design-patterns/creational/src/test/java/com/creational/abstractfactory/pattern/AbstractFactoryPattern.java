package com.creational.abstractfactory.pattern;

import org.junit.Test;

public class AbstractFactoryPattern {

	@Test
	public void execute() {
		FactoryProducer factoryProducer = new FactoryProducer();

		AbstractFactory shapeFactory = factoryProducer.getFactory("shape");
		AbstractFactory colorFactory = factoryProducer.getFactory("color");

		Shape circle = shapeFactory.getShape("circle");
		Shape square = shapeFactory.getShape("square");
		Shape rectangle = shapeFactory.getShape("rectangle");

		circle.draw();
		square.draw();
		rectangle.draw();

		Color red = colorFactory.getColor("red");
		Color blue = colorFactory.getColor("blue");
		Color green = colorFactory.getColor("green");

		red.paint();
		blue.paint();
		green.paint();
	}
}