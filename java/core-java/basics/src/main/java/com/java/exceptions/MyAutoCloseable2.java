package com.java.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyAutoCloseable2 implements AutoCloseable {

	@Override
	public void close() throws Exception {
		throw new RuntimeException("Exception from MyAutoCloseable close method");
	}

	public void hello() {
		log.info("Hello from MyAutoCloseable");
	}

}
