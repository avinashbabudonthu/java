package com.calculate;

import java.util.Arrays;
import java.util.Objects;

public class Calculator {

	public int sum(int... numbers) {

		if (Objects.nonNull(numbers) && numbers.length > 0) {
			return Arrays.stream(numbers).sum();
		} else {
			return -1;
		}

	}
}