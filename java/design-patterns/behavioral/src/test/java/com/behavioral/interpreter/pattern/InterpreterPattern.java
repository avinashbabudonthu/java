package com.behavioral.interpreter.pattern;

import org.junit.Test;

public class InterpreterPattern {

	@Test
	public void execute() {
		Expression isMaleExpression = maleExpression();
		Expression isFemaleExpression = femaleExpression();

		System.out.println("or expresion - context == jack: " + isMaleExpression.interpreter("jack"));
		System.out.println("or expresion - context == jim: " + isMaleExpression.interpreter("jim"));

		System.out.println("and expresion - context == julie: " + isFemaleExpression.interpreter("julie jane"));
		System.out.println("and expresion - context == jean: " + isFemaleExpression.interpreter("jean"));
	}

	private Expression maleExpression() {
		Expression expression1 = new TerminalExpression("jack");
		Expression expression2 = new TerminalExpression("john");

		return new OrExpression(expression1, expression2);
	}

	private Expression femaleExpression() {
		Expression expression1 = new TerminalExpression("jane");
		Expression expression2 = new TerminalExpression("julie");

		return new AndExpression(expression1, expression2);
	}
}