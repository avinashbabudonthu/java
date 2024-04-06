package com.java.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAutoCloseable implements AutoCloseable {

	private static final Logger log = LoggerFactory.getLogger(MyAutoCloseable.class);

	@Override
	public void close() throws Exception {
		log.info("MyAutoCloseable close method");
	}

	public void hello() {
		log.info("Hello from MyAutoCloseable");
	}

}
