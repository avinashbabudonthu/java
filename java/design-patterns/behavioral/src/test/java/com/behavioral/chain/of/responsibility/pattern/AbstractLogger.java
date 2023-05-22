package com.behavioral.chain.of.responsibility.pattern;

import java.util.Objects;

public abstract class AbstractLogger {

	public static final int INFO = 1;
	public static final int DEBUG = 2;
	public static final int ERROR = 3;

	protected int level;
	protected AbstractLogger nextLogger;

	protected abstract void write(String message);

	public void setNextLogger(AbstractLogger nextLogger) {
		this.nextLogger = nextLogger;
	}

	public void logMessage(int level, String message) {
		if (this.level <= level) {
			write(message);
		}
		if (Objects.nonNull(nextLogger)) {
			nextLogger.logMessage(level, message);
		}
	}

}