package com.mockito.hello.world;

import java.util.List;

public class HelloWorld {

	public int sum(int a, int b) {
		return a + b;
	}

	public String hello(String name) {
		return "Hello " + name;
	}

	public void add(List<String> list, String item) {
		list.add(item);
	}
}
