package com.calculator;

public class Calculator {

	public long sum(int... numbers) {
		long result = 0L;
		for (int number : numbers) {
			result = result + number;
		}

		return result;
	}

	public long multiple(int... numbers) {
		long result = 1L;
		for (int number : numbers) {
			result = result * number;
		}

		return result;
	}
}
