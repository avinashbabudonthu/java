package com.behavioral.strategy.pattern;

public class OperationMultiply implements Strategy {

	@Override
	public int doOperation(int i, int j) {
		return i * j;
	}

}
