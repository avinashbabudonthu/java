package com.junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@TestInstance(Lifecycle.PER_CLASS) // if don't declare this annotation, we need to declare @AfterAll method as static
public class AfterAnnotations {

	@AfterAll
	public void teardownAll() {
		log.info("@AfterAll - executes once after all test cases");
	}

	@AfterEach
	public void teardown() {
		log.info("@AfterEach - executes once after each test case");
	}

	@DisplayName("Test method 1")
	@Test
	public void test1() {
		log.info("test1");
	}

	@DisplayName("Test method 2")
	@Test
	public void test2() {
		log.info("test2");
	}
}
