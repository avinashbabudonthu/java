package com.behavioral.pattern.nullobject;

import java.util.ArrayList;
import java.util.List;

public class Database {

	private List<String> names;

	public Database() {
		names = new ArrayList<>();
		names.add("jack");
		names.add("jill");
		names.add("john");
		names.add("james");
	}

	public boolean exists(String name) {
		boolean exist = false;
		for (String s : names) {
			if (exist = s.equals(name)) {
				break;
			}
		}

		return exist;
	}
}
