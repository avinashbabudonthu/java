package com.structural.facade.pattern;

public class ShapeMaker {

	private Shape square;
	private Shape pentagon;
	private Shape hexagon;

	public ShapeMaker() {
		square = new Square();
		pentagon = new Pentagon();
		hexagon = new Hexagon();
	}

	public void drawSquare() {
		square.draw();
	}

	public void drawPentagon() {
		pentagon.draw();
	}

	public void drawHexagon() {
		hexagon.draw();
	}
}