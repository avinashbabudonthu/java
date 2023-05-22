package com.structural.composite.pattern;

import java.util.Optional;

import org.junit.Test;

public class CompositePattern {

	@Test
	public void execute() {
		Employee ceo = new Employee("jack", "founder");

		Employee enggHead = new Employee("john", "engg-head");
		Employee techHead = new Employee("jim", "tech-head");

		Employee enggDev1 = new Employee("tim", "engg");
		Employee enggDev2 = new Employee("ana", "engg");

		Employee techDev1 = new Employee("jane", "tech");
		Employee techDev2 = new Employee("josh", "tech");
		Employee techDev3 = new Employee("jack", "tech");

		enggHead.addReportee(enggDev1);
		enggHead.addReportee(enggDev2);

		techHead.addReportee(techDev1);
		techHead.addReportee(techDev2);
		techHead.addReportee(techDev3);

		ceo.addReportee(enggHead);
		ceo.addReportee(techHead);

		System.out.println(ceo);

		ceo.getReportees().stream().forEach(reportee -> {
			System.out.println(reportee);
			Optional.ofNullable(reportee.getReportees()).ifPresent(list -> list.stream().forEach(System.out::println));
		});
	}
}