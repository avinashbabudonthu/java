package com.mockito.wrong.type.of.returnvalue;

public class Outside {

	private Foo foo;

	public Outside(Foo foo) {
		this.foo = foo;
	}

	public Product produce() {
		return new Product(foo);
	}
}
