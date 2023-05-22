package com.mockito.wrong.type.of.returnvalue;

public class Product {

	private Bar bar;

	public Product(Foo foo) {
		bar = foo.getBar();
	}
}
