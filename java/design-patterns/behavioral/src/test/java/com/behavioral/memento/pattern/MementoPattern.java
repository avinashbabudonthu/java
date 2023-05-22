package com.behavioral.memento.pattern;

import org.junit.Test;

public class MementoPattern {

	@Test
	public void execute() {
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();

		originator.setState("state-0");
		careTaker.addMementoToList(originator.saveStateToMemento());

		originator.setState("state-1");
		careTaker.addMementoToList(originator.saveStateToMemento());

		originator.setState("state-2");
		careTaker.addMementoToList(originator.saveStateToMemento());

		originator.restoreStateFromMemento(careTaker.getMemento(0));
		System.out.println("index-0: " + originator.getState());

		originator.restoreStateFromMemento(careTaker.getMemento(1));
		System.out.println("index-1: " + originator.getState());

		originator.restoreStateFromMemento(careTaker.getMemento(2));
		System.out.println("index-2: " + originator.getState());
	}
}