package com.creational.prototype.pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Rectangle extends Shape {

	public Rectangle() {
		type = "rectangle";
	}

	@Override
	public void draw() {
		log.info("rectangle draw() method");
	}

}
