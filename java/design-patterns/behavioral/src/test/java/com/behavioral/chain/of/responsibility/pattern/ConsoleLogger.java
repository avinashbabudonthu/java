package com.behavioral.chain.of.responsibility.pattern;

public class ConsoleLogger extends AbstractLogger {

	public ConsoleLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("console logger : " + message);
	}

}