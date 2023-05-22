package com.behavioral.chain.of.responsibility.pattern;

public class FileLogger extends AbstractLogger {

	public FileLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("file logger : " + message);
	}

}