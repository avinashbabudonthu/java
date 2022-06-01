package com.creational.factory.pattern;

public class ShapeFactory {

	public Shape getShape(String shapeType) {
		Shape shape = null;
		switch (shapeType.trim().toLowerCase()) {
			case "square":
				shape = new Square();
				break;
			case "circle":
				shape = new Circle();
				break;
			case "rectangle":
				shape = new Rectangle();
				break;
		}

		return shape;
	}
}