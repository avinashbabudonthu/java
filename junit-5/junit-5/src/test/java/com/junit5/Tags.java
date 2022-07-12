package com.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Tag("Test case")
public class Tags {

	@DisplayName("Test 1")
	@Tag("Test method 1")
	@Test
	public void test1() {
		log.info("test 1");
		Assertions.assertEquals(10, 10);
	}
}
