package com.interfaces;

public interface DefaultStaticMethodsInterface {

	public static void staticMethod1() {
		System.out.println("staticMethod1");
	}

	public default void defaultMethod1() {
		System.out.println("defaultMethod1");
	}
}