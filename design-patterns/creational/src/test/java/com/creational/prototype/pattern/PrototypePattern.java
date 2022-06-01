package com.creational.prototype.pattern;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrototypePattern {

	@Test
	public void execute() {
		ShapeCache.loadCache();

		Shape cachedCircle = ShapeCache.getShape("1");
		Shape cachedSquare = ShapeCache.getShape("2");
		Shape cachedRectangle = ShapeCache.getShape("3");

		log.info(cachedCircle.getType());
		cachedCircle.draw();

		log.info(cachedSquare.getType());
		cachedSquare.draw();

		log.info(cachedRectangle.getType());
		cachedRectangle.draw();
	}
}