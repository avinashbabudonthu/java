package com.behavioral.strategy.pattern;

import org.junit.Test;

import com.behavioral.strategy.pattern.Context;
import com.behavioral.strategy.pattern.OperationAdd;
import com.behavioral.strategy.pattern.OperationMultiply;
import com.behavioral.strategy.pattern.OperationSubtract;

public class StrategyPattern {

	@Test
	public void execute() {
		OperationAdd operationAdd = new OperationAdd();
		OperationSubtract operationSubtract = new OperationSubtract();
		OperationMultiply operationMultiply = new OperationMultiply();

		Context addContext = new Context(operationAdd);
		Context subtractContext = new Context(operationSubtract);
		Context multiplyContext = new Context(operationMultiply);

		System.out.println(addContext.executeStrategy(10, 5));
		System.out.println(subtractContext.executeStrategy(10, 5));
		System.out.println(multiplyContext.executeStrategy(10, 5));
	}
}