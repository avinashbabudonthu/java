package com.interfaces;

import org.junit.Test;

public class DefaultStaticMethodsInterfaceTest {

	@Test
	public void staticMethod1() {
		DefaultStaticMethodsInterface.staticMethod1();
	}

	private class DefaultStaticMethodsInterfaceImpl implements DefaultStaticMethodsInterface {

		public void callDefaultMethod1() {
			DefaultStaticMethodsInterface.super.defaultMethod1();
		}

	}

	@Test
	public void defaultMethod1() {
		new DefaultStaticMethodsInterfaceImpl().defaultMethod1();
	}

	@Test
	public void defaultMethod1FromImplementedClass() {
		new DefaultStaticMethodsInterfaceImpl().callDefaultMethod1();
	}
}