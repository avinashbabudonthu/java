package com.structural.flyweight.pattern;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FlyweightPattern {

	@Test
	public void execute() throws InterruptedException {
		List<String> colors = Arrays.asList("red", "green", "blue", "black", "white");

		for (int i = 0; i < 20; i++) {
			Shape shape = ShapeFactory.getShape(colors.get((int) (Math.random() * colors.size())));
			Thread.sleep(1000 * 1);
			shape.draw();
		}
	}
}