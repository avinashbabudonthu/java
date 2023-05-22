package com.creational.builder.pattern;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BuilderPattern {

	@Test
	public void execute() {
		MealBuilder mealBuilder = new MealBuilder();

		System.out.println("------ veg meal --------");
		Meal vegMeal = mealBuilder.prepareVegMeal();
		log.info("veg meal price={}", vegMeal.getPrice());
		vegMeal.display();

		System.out.println("------ non veg meal --------");
		Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
		log.info("non veg meal price={}", nonVegMeal.getPrice());
		nonVegMeal.display();
	}
}