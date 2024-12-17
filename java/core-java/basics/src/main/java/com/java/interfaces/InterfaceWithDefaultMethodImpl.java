package com.java.interfaces;

public class InterfaceWithDefaultMethodImpl implements InterfaceWithDefaultMethod {

	@Override
	public void method3() {
		System.out.println("method3");
	}

	public void method1() {
		System.out.println("InterfaceWithDefaultMethodImpl method1");

		InterfaceWithDefaultMethod.super.method1();
		InterfaceWithDefaultMethod.method2();

		InterfaceWithDefaultMethod object = new InterfaceWithDefaultMethodImpl();
		object.method3();
	}

	/**
	 * Output:
	 * InterfaceWithDefaultMethodImpl method1
	 * default method1()
	 * method 2
	 * method3
	 *
	 */
	public static void main(String[] args) {
		InterfaceWithDefaultMethod interface1 = new InterfaceWithDefaultMethodImpl();
		interface1.method1();
	}

}