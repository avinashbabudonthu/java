package com.structural.filter.pattern;

import java.util.Arrays;
import java.util.List;

public class AndCriteria implements Criteria {
	private List<Criteria> criterias;

	public AndCriteria(Criteria... criterias) {
		this.criterias = Arrays.asList(criterias);
	}

	@Override
	public List<Person> filter(List<Person> inputPersonsList) {
		for (int i = 0; i < criterias.size(); i++) {
			inputPersonsList = criterias.get(i).filter(inputPersonsList);
		}
		return inputPersonsList;
	}

}