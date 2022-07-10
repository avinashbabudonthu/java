package com.java.util.function;

import java.util.function.BiFunction;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BiFunctionPractice {

	@Test
	public void biFunction() {
		/* In the generic
		 *  1,2 values - argument data type
		 *  3rd value - return type 
		*/
		BiFunction<String, String, String> biFunction = (firstName, lastName) -> firstName.concat(" ").concat(lastName);
		log.info(biFunction.apply("jim", "jack"));
	}
}
