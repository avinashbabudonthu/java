package com.behavioral.memento.pattern;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {

	private List<Memento> mementoList = new ArrayList<>();

	public void addMementoToList(Memento memento) {
		mementoList.add(memento);
	}

	public Memento getMemento(int index) {
		return mementoList.get(index);
	}
}