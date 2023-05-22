package com.behavioral.pattern.nullobject;

public class NullCusomer extends AbstractCustomer {

	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	public String getName() {
		return "no name";
	}

}
