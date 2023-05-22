package com.structural.bridge.pattern;

public class BlueCircle implements DrawAPI {

	@Override
	public void drawCircle(int radius) {
		System.out.println("blue circle draw with radius: " + radius);
	}

}
