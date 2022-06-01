package com.behavioral.strategy.pattern;

public class OperationAdd implements Strategy {

	@Override
	public int doOperation(int i, int j) {
		return i + j;
	}

}
