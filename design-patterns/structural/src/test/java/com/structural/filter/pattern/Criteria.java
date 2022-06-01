package com.structural.filter.pattern;

import java.util.List;

public interface Criteria {

	public List<Person> filter(List<Person> inputPersonsList);
}