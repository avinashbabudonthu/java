package com.behavioral.pattern.observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeatherObserver implements Observer {

	private int value1;
	private int value2;
	private int value3;
	private Subject subject;

	public WeatherObserver(Subject subject) {
		this.subject = subject;
		this.subject.addObserver(this);
	}

	@Override
	public void update(int value1, int value2, int value3) {
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
		print();
	}

	private void print() {
		log.info("updated - value1={}, value2={}, value3={}", value1, value2, value3);
	}

}
