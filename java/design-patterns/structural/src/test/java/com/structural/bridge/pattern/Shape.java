package com.structural.bridge.pattern;

public abstract class Shape {

	protected DrawAPI drawAPI;

	public Shape(DrawAPI drawApi) {
		this.drawAPI = drawApi;
	}

	public abstract void draw();

}