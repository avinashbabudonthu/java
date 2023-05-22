package com.creational.prototype.pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Square extends Shape {

	public Square() {
		type = "square";
	}

	@Override
	public void draw() {
		log.info("square draw() method");
	}

}