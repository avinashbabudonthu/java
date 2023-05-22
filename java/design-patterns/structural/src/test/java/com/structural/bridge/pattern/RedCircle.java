package com.structural.bridge.pattern;

public class RedCircle implements DrawAPI {

	@Override
	public void drawCircle(int radius) {
		System.out.println("red-circle draw with radius: " + radius);
	}

}
