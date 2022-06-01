package com.structural.proxy.pattern;

import org.junit.Test;

public class ProxyPattern {

	@Test
	public void execute() {
		ImageProxy imageProxy = new ImageProxy("file1.jpg");

		imageProxy.display();
		System.out.println("--------");
		imageProxy.display();
	}
}