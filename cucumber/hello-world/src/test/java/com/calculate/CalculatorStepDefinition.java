package com.calculate;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculatorStepDefinition {

	private Calculator calculator;
	private Integer result;

	@Given("^there are two Integers$")
	public void there_are_two_Integers() throws Throwable {
		calculator = new Calculator();
	}

	@When("^Two number are passed as arguments to method$")
	public void two_number_are_passed_as_arguments_to_method() throws Throwable {
		result = calculator.sum(10, 20);
	}

	@Then("^We can sum those numbers and return result$")
	public void we_can_sum_those_numbers_and_return_result() throws Throwable {
		Assert.assertEquals("30", result.toString());
	}

}
