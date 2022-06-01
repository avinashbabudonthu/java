package com.structural.filter.pattern;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaSingle implements Criteria {

	@Override
	public List<Person> filter(List<Person> inputPersonsList) {
		return inputPersonsList.stream().filter(person -> "single".equalsIgnoreCase(person.getMaritalStatus()))
				.collect(Collectors.toList());
	}

}