package com.structural.filter.pattern;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FilterPattern {

	@Test
	public void execute() {
		List<Person> persons = new ArrayList<>();

		persons.add(new Person("jack", "male", "single"));
		persons.add(new Person("jamy", "female", "single"));
		persons.add(new Person("jim", "male", "single"));
		persons.add(new Person("kathy", "female", "single"));
		persons.add(new Person("json", "male", "single"));
		persons.add(new Person("john", "male", "married"));
		persons.add(new Person("tilda", "female", "married"));

		Criteria maleCriteria = new CriteriaMale();
		Criteria femaleCriteria = new CriteriaFemale();
		Criteria single = new CriteriaSingle();
		Criteria singleMale = new AndCriteria(maleCriteria, single);
		Criteria singleOrFemale = new OrCriteria(single, femaleCriteria);

		System.out.println("males: " + maleCriteria.filter(persons));
		System.out.println("females: " + femaleCriteria.filter(persons));
		System.out.println("singles: " + single.filter(persons));
		System.out.println("singleMale: " + singleMale.filter(persons));
		System.out.println("singleOrFemale: " + singleOrFemale.filter(persons));
	}
}