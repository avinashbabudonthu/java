package com.behavioral.chain.of.responsibility.pattern;

import org.junit.Test;

public class ChainOfResponsibilityPattern {

	@Test
	public void execute() {
		AbstractLogger loggerChain = getChainOfLoggers();

		loggerChain.logMessage(AbstractLogger.INFO, "info message");
		System.out.println("-----------------");
		loggerChain.logMessage(AbstractLogger.DEBUG, "debug message");
		System.out.println("-----------------");
		loggerChain.logMessage(AbstractLogger.ERROR, "error message");
	}

	private AbstractLogger getChainOfLoggers() {
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);

		return errorLogger;
	}
}