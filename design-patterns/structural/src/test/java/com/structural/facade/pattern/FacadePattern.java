package com.structural.facade.pattern;

import org.junit.Test;

public class FacadePattern {

	@Test
	public void execute() {
		ShapeMaker shapeMaker = new ShapeMaker();

		shapeMaker.drawSquare();
		shapeMaker.drawPentagon();
		shapeMaker.drawHexagon();
	}
}