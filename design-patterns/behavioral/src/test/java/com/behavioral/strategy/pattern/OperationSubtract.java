package com.behavioral.strategy.pattern;

public class OperationSubtract implements Strategy {

	@Override
	public int doOperation(int i, int j) {
		return i - j;
	}

}
