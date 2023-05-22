package com.structural.bridge.pattern;

import org.junit.Test;

public class BridgePattern {

	@Test
	public void execute() {
		Shape redCircle = new Circle(10, new RedCircle());
		Shape blueCircle = new Circle(12, new BlueCircle());

		redCircle.draw();
		blueCircle.draw();
	}
}