package com.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DisplayNameAnnotation {

	@DisplayName("Test method 1")
	@Test
	public void test1() {
		log.info("test1");
	}
}
