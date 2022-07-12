package com.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Assumptions are used to run tests only if certain conditions are met. 
 * This is typically used for external conditions that are required for the test to 
 * run properly, but which are not directly related to whatever is being tested
 * 
 * @author Avinash Babu Donthu
 *
 */
public class Assumptions {

	@DisplayName("Assume True demo")
	@Test
	public void assumeTrue() {
		org.junit.jupiter.api.Assumptions.assumeTrue(10 > 5);
		Assertions.assertEquals(10, 10);
	}

	@DisplayName("Assume False demo")
	@Test
	public void assumeFalse() {
		// if we make greater than as less than then test case won't execute
		org.junit.jupiter.api.Assumptions.assumeFalse(10 > 20);
		Assertions.assertEquals(10, 10);
	}

	@DisplayName("Assuming That demo")
	@Test
	public void assumingThat() {
		final String name = "jack";
		org.junit.jupiter.api.Assumptions.assumingThat(name.equals("jack"),
				() -> Assertions.assertEquals(10, 10));
	}
}
