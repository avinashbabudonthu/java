package com.calculate;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SumStepDefinition {

	private Calculator calculator;
	private Integer result;

	@Given("I have Calculator")
	public void i_have_calculator() {
		calculator = new Calculator();
	}

	@When("I have {int} and {int}")
	public void add_numbers(Integer number1, Integer number2) {
		result = calculator.sum(number1, number2);
	}

	@Then("I should get {int}")
	public void result(Integer expected) {
		Assert.assertEquals(expected.toString(), result.toString());
	}
}