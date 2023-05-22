package com.behavioral.iterator.pattern;

import java.util.Arrays;
import java.util.List;

public class NameRepository implements Container {

	private List<String> names = Arrays.asList("jack", "jill", "john", "jim", "tim", "jane", "jan");

	@Override
	public Iterator getIterator() {
		return new NameIterator();
	}

	private class NameIterator implements Iterator {

		int index;

		@Override
		public boolean hasNext() {
			if (index < names.size()) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if (this.hasNext()) {
				return names.get(index++);
			}
			return null;
		}

	}

}