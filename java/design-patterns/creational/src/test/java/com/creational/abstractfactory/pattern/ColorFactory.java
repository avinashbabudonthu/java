package com.creational.abstractfactory.pattern;

public class ColorFactory extends AbstractFactory {

	@Override
	public Shape getShape(String shapeType) {
		return null;
	}

	@Override
	public Color getColor(String colorType) {
		Color color = null;
		switch (colorType.trim().toLowerCase()) {
			case "red":
				color = new Red();
				break;
			case "blue":
				color = new Blue();
				break;
			case "green":
				color = new Green();
				break;
		}
		return color;
	}

}