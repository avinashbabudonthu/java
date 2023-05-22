package com.cucumber.step.definitions;

import java.util.List;

import org.junit.Assert;

import com.calculator.Calculator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class ScenarionOutlineStepDefinition {

	private Calculator calculator;
	private long actual;
	private List<String> operations;

	/**
	 * We can use io.cucumber.datatable.DataTable as argument 
	 * (or)
	 * We can use List&lt;String&gt; also
	 * 
	 * @param dataTable
	 */
	@Given("Calculate Operations")
	public void calculateOperations(DataTable dataTable) {
		operations = dataTable.asList();
		calculator = new Calculator();

	}

	@Given("Two numbers")
	public void weHaveTwoNumbers() {
		System.out.println("addition of 2 numbers");
	}

	@When("Numbers are {int} and {int}")
	public void additionInput(Integer num1, Integer num2) {
		if (operations.contains("add")) {
			actual = calculator.sum(num1, num2);
		}

	}

	@Then("Addition is {int}")
	public void additionResult(Integer expected) {
		Assert.assertEquals(String.valueOf(expected), String.valueOf(actual));
	}
}
