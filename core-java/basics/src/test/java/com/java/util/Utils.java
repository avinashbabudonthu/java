package com.java.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;

@Slf4j
public class Utils {

	@Test
	public void createBasicAuthHeader() throws UnsupportedEncodingException {
		final String credentials = "admin:admin123";
		String basicAuthorizationHeader = "Basic "
				+ DatatypeConverter.printBase64Binary(credentials.getBytes("UTF-8"));
		log.info("basic authorization header={}", basicAuthorizationHeader);
	}

	@Test
	public void generate10DigitRandomNumber(){
		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		log.info("number={}", number);
	}

}