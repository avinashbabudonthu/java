package com.behavioral.chain.of.responsibility.pattern;

public class ErrorLogger extends AbstractLogger {

	public ErrorLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("error logger : " + message);
	}
}