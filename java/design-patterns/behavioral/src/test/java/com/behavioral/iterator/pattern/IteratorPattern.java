package com.behavioral.iterator.pattern;

import org.junit.Test;

public class IteratorPattern {

	@Test
	public void execute() {
		NameRepository nameRepository = new NameRepository();

		for (Iterator iterator = nameRepository.getIterator(); iterator.hasNext();) {
			String name = iterator.next().toString();
			System.out.println(name);
		}
	}
}