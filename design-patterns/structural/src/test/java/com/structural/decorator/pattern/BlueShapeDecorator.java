package com.structural.decorator.pattern;

public class BlueShapeDecorator extends ShapeDecorator {

	public BlueShapeDecorator(Shape shape) {
		super(shape);
	}

	@Override
	public void draw() {
		shape.draw();
		fillBlueColor();
	}

	public void fillBlueColor() {
		System.out.println("filling blue color");
	}
}