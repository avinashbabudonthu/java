package com.behavioral.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {

	private int value1;
	private int value2;
	private int value3;
	private List<Observer> observerList;

	public WeatherStation() {
		observerList = new ArrayList<>();
	}

	public void setValue1(int value1) {
		this.value1 = value1;
		notifyAllObservers();
	}

	public void setValue2(int value2) {
		this.value2 = value2;
		notifyAllObservers();
	}

	public void setValue3(int value3) {
		this.value3 = value3;
		notifyAllObservers();
	}

	public void setObserverList(List<Observer> observerList) {
		this.observerList = observerList;
	}

	@Override
	public void addObserver(Observer o) {
		observerList.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observerList.remove(o);
	}

	@Override
	public void notifyAllObservers() {
		for (Observer o : observerList) {
			o.update(value1, value2, value3);
		}
	}

}
