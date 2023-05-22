package com.behavioral.pattern.observer;

public interface Subject {

	void addObserver(Observer o);

	void removeObserver(Observer o);

	void notifyAllObservers();

}