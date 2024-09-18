package com.java.step.defs;

import com.java.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//@Slf4j
public class CalculatorStepDefinition001 {

    private Calculator calculator;
    private Long result;

    @Given("001 two numbers")
    public void given() {
        calculator = new Calculator();
    }

    @When("001 two numbers are passed as arguments")
    public void when() {
        result = calculator.sum(10L, 20L);
    }

    @Then("001 get sum of numbers")
    public void then() {
        System.out.println("result = " + result);
    }
}