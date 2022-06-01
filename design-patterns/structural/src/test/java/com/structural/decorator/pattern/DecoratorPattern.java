package com.structural.decorator.pattern;

import org.junit.Test;

public class DecoratorPattern {

	@Test
	public void execute() {
		Shape square = new Square();
		Shape rectangle = new Rectangle();

		ShapeDecorator blueSquare = new BlueShapeDecorator(square);
		ShapeDecorator blueRectangle = new BlueShapeDecorator(rectangle);

		square.draw();
		rectangle.draw();
		blueSquare.draw();
		blueRectangle.draw();
	}
}