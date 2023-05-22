package com.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DisabledAnnotation {

	@DisplayName("Test method 1")
	@Disabled
	@Test
	public void test1() {
		log.info("test1");
	}
}
