package com.behavioral.pattern.nullobject;

public class RealCustomer extends AbstractCustomer {

	private String name;

	public RealCustomer(String name) {
		this.name = name;
	}

	@Override
	public boolean isNull() {
		return false;
	}

	@Override
	public String getName() {
		return name;
	}

}
