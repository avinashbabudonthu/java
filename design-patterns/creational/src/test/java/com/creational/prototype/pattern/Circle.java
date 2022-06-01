package com.creational.prototype.pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Circle extends Shape {

	public Circle() {
		type = "circle";
	}

	@Override
	public void draw() {
		log.info("circle draw() method");
	}

}
