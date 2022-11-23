package com.java.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * java.util.Base64 encoding/decoding practice
 * @author Avinash Babu Donthu
 *
 */
@Slf4j
public class Base64EncodeDecodePractice {

	@Test
	public void encode() {
		final String testSting = "Let's encode @ password";

		String encodedString1 = Base64.getEncoder().encodeToString(testSting.getBytes());
		log.info("encodedString1={}", encodedString1);

		String encodedString2 = Base64.getEncoder().encodeToString(testSting.getBytes(StandardCharsets.UTF_8));
		log.info("encodedString2={}", encodedString2);
	}

	@Test
	public void decode() {
		final String testSting = "admin:admin";
		String encodedString1 = Base64.getEncoder().encodeToString(testSting.getBytes());
		String decodedString1 = new String(Base64.getDecoder().decode(encodedString1));
		log.info("encodedString1={}, decodedString1={}", encodedString1, decodedString1);

		String encodedString2 = Base64.getEncoder().encodeToString(testSting.getBytes(StandardCharsets.UTF_8));
		String decodedString2 = new String(Base64.getDecoder().decode(encodedString2), StandardCharsets.UTF_8);
		log.info("encodedString2={}, decodedString2={}", encodedString2, decodedString2);
	}

	@Test
	public void usernameAndPassword() {
		String encodedString = "YWRtaW46YWRtaW4=";
		String decodedString2 = new String(Base64.getDecoder().decode(encodedString), StandardCharsets.UTF_8);
		log.info("encodedString2={}, decodedString2={}", encodedString, decodedString2); // encodedString2=YWRtaW46YWRtaW4=, decodedString2=admin:admin

		String[] credentials = decodedString2.split(":");
		log.info("username={}, password={}", credentials[0], credentials[1]); // username=admin, password=admin
	}

}