package com.annotations.deprecated;

import org.junit.Test;

public class AnnotationsPractice {

	@Deprecated
	public void method1() {
		System.out.println("method 1");
	}

	public void method2() {
		System.out.println("method 2");
	}

	@Test
	public void test1() {
		method1();
		method2();
	}
}
