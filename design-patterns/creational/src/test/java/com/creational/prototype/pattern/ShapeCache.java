package com.creational.prototype.pattern;

import java.util.HashMap;
import java.util.Map;

public class ShapeCache {

	private static Map<String, Shape> shapeMap = new HashMap<>();

	public static Shape getShape(String id) {
		Shape cachedShape = shapeMap.get(id);
		return (Shape) cachedShape.clone();
	}

	// execute DB query and load into cache
	public static void loadCache() {
		Circle circle = new Circle();
		circle.setId("1");
		shapeMap.put(circle.getId(), circle);

		Square square = new Square();
		square.setId("2");
		shapeMap.put(square.getId(), square);

		Rectangle rectangle = new Rectangle();
		rectangle.setId("3");
		shapeMap.put(rectangle.getId(), rectangle);
	}
}