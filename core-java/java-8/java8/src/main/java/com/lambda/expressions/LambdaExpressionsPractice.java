package com.lambda.expressions;

import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaExpressionsPractice {

	@Test
	public void printListElementsUsingStreamAndLambdaExpressions() {
		List<Integer> numbers = List.<Integer>of(1, 2, 3, 4, 5, 6);
		Stream<Integer> stream = numbers.stream();
		stream.forEach(number -> log.info("{}", number));
	}

}