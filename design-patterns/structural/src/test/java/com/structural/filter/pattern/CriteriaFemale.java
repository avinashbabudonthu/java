package com.structural.filter.pattern;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaFemale implements Criteria {

	@Override
	public List<Person> filter(List<Person> inputPersonsList) {
		return inputPersonsList.stream().filter(person -> "female".equalsIgnoreCase(person.getGender()))
				.collect(Collectors.toList());
	}

}