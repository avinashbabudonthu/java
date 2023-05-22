package com.creational.abstractfactory.pattern;

public class FactoryProducer {

	public AbstractFactory getFactory(String factoryType) {
		AbstractFactory abstractFactory = null;
		switch (factoryType.trim().toLowerCase()) {
			case "shape":
				abstractFactory = new ShapeFactory();
				break;
			case "color":
				abstractFactory = new ColorFactory();
				break;
		}

		return abstractFactory;
	}
}