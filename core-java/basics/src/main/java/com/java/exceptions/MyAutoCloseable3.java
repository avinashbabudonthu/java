package com.java.exceptions;

public class MyAutoCloseable3 implements AutoCloseable {

	@Override
	public void close() throws Exception {
		throw new RuntimeException("Exception from MyAutoCloseable close method");
	}

	public void hello() {
		throw new RuntimeException("Exception from MyAutoCloseable hello method");
	}

}
