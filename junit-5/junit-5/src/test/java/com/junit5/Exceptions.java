package com.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Exceptions {

	@DisplayName("Assert Throws")
	@Test
	public void assertThrows() {
		Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
			throw new RuntimeException("run time exception");
		});
		Assertions.assertEquals(exception.getMessage(), "run time exception");
	}
}
