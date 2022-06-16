package com.java.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyAutoCloseable implements AutoCloseable {

	@Override
	public void close() throws Exception {
		log.info("MyAutoCloseable close method");
	}

	public void hello() {
		log.info("Hello from MyAutoCloseable");
	}

}
