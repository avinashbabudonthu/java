package com.creational.singleton;

/**
 * 1. create static variable which is an instance of a class
 * 2. make constructor private, no need to make class final. Since constructor is private we cannot sub class it
 * 3. write static method which returns the instance of created as static variable
 * @author Avinash Babu Donthu
 *
 */
public class EagerSingletonClass {

	private static EagerSingletonClass INSTANCE = new EagerSingletonClass();

	private EagerSingletonClass() {

	}

	public static EagerSingletonClass getInstnace() {
		return INSTANCE;
	}
}
