package com.method.references;

import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MethodReferencePractice {

	private static void print(Integer number) {
		log.info("{}", number);
	}

	@Test
	public void printListElementsUsingStreamsAndMethodReference() {
		List<Integer> numbers = List.<Integer>of(1, 2, 3, 4, 5, 6);
		Stream<Integer> stream = numbers.stream();
		stream.forEach(MethodReferencePractice::print);
	}
}
