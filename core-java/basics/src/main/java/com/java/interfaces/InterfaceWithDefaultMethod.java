package com.java.interfaces;

public interface InterfaceWithDefaultMethod {

	default void method1() {
		System.out.println("default method1()");
	}

	static void method2() {
		System.out.println("method 2");
	}

	public void method3();

}