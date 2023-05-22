package com.cucumber.step.definitions;

import org.junit.Assert;
import org.mockito.Mockito;

import com.calculator.Calculator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdditionStepDefinition {

	private Calculator calculator;

	private Calculator calculatorMock = Mockito.mock(Calculator.class);

	private long actual;

	@Given("create calculator object")
	public void given() {
		calculator = new Calculator();
	}

	@When("numbers are {int} and {int}")
	public void when(int num1, int num2) {
		actual = calculator.sum(num1, num2);
	}

	@Then("result is {int}")
	public void then(int expected) {
		Assert.assertEquals(String.valueOf(expected), String.valueOf(actual));
	}
}
