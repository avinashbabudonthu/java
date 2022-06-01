package com.structural.filter.pattern;

import java.util.List;

public class OrCriteria implements Criteria {

	private Criteria criteria1;
	private Criteria criteria2;

	public OrCriteria(Criteria criteria1, Criteria criteria2) {
		this.criteria1 = criteria1;
		this.criteria2 = criteria2;
	}

	@Override
	public List<Person> filter(List<Person> inputPersonsList) {
		List<Person> criteria1Result = criteria1.filter(inputPersonsList);
		List<Person> criteria2Result = criteria2.filter(inputPersonsList);

		for (Person person : criteria1Result) {
			if (!criteria2Result.contains(person)) {
				criteria2Result.add(person);
			}
		}

		return criteria2Result;
	}

}