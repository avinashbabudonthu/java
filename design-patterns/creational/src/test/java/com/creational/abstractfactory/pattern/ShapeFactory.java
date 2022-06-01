package com.creational.abstractfactory.pattern;

public class ShapeFactory extends AbstractFactory {

	@Override
	public Shape getShape(String shapeType) {
		Shape shape = null;
		switch (shapeType.trim().toLowerCase()) {
			case "circle":
				shape = new Circle();
				break;
			case "square":
				shape = new Square();
				break;
			case "rectangle":
				shape = new Rectangle();
				break;
		}

		return shape;
	}

	@Override
	public Color getColor(String colorType) {
		return null;
	}
}