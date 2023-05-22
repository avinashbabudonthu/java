package com.cucumber.step.definitions;

import org.junit.Assert;
import org.mockito.Mockito;

import com.calculator.Calculator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberMockitoStepDefinition {

	private Calculator calculatorMock;

	private long actual;

	@Given("create calculator mock object")
	public void given() {
		calculatorMock = Mockito.mock(Calculator.class);
	}

	@When("mockito input numbers are {int} and {int}")
	public void when(int num1, int num2) {
		Mockito.when(calculatorMock.sum(Mockito.any())).thenReturn(40L);
		actual = calculatorMock.sum(num1, num2);
	}

	@Then("mockito result is {int}")
	public void then(int expected) {
		Assert.assertEquals(String.valueOf(expected), String.valueOf(actual));
	}
}
