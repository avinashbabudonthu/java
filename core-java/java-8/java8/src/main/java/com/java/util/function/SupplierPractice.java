package com.java.util.function;

import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SupplierPractice {

	@Test
	public void convertStringToUpperUsingFunctionAndSupplier() {
		String input = "jack";

		// Function<String, String> function = (name) -> name.toUpperCase();
		Function<String, String> function = String::toUpperCase; // same as above lambda expression

		Supplier<String> supplier = () -> function.apply(input);
		log.info("result={}", supplier.get());
	}

	/**
	* This is lazy operation {@see concatAndConvertCase} do not execute until log.info is called
	*/
	@Test
	public void highOrderFunctions() {
		// Function<String, String> function = (input) -> input.toUpperCase();
		Function<String, String> function = String::toUpperCase; // same as above lambda expression
		Supplier<String> supplier = concatAndConvertCase("jim", "jack", function);
		log.info("output={}", supplier.get());
	}

	private Supplier<String> concatAndConvertCase(String firstName, String lastName,
			Function<String, String> function) {
		return () -> {
			String str1 = firstName;
			String str2 = lastName;

			if (null != function) {
				str1 = function.apply(str1);
				str2 = function.apply(str2);
			}
			return str1.concat(" ").concat(str2);
		};
	}

}