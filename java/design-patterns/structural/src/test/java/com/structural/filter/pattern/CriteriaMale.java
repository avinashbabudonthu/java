package com.structural.filter.pattern;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaMale implements Criteria {

	@Override
	public List<Person> filter(List<Person> inputPersonsList) {
		return inputPersonsList.stream().filter(person -> "male".equalsIgnoreCase(person.getGender()))
				.collect(Collectors.toList());
	}

}