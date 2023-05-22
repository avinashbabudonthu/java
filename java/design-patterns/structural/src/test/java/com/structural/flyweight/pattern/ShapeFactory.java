package com.structural.flyweight.pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ShapeFactory {

	private static final Map<String, Shape> shapeMap = new HashMap<>();

	public static Shape getShape(String color) {
		Shape shape = shapeMap.get(color);

		if (Objects.isNull(shape)) {
			shape = new Circle(color);
			shapeMap.put(color, shape);
			System.out.println("created circle with color: " + color);
		}

		return shape;
	}

}