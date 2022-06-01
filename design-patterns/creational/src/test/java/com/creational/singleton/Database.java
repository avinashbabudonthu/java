package com.creational.singleton;

public enum Database {

	INSTANCE;

	public void connect() {
		System.out.println("connecting");
	}

	public void disconnet() {
		System.out.println("disconnect");
	}
}
