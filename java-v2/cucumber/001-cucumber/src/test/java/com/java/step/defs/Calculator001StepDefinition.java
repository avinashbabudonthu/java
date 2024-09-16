package com.java.step.defs;

import com.java.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//@Slf4j
public class Calculator001StepDefinition {

    private Calculator calculator;
    private Long result;

    @Given("two numbers")
    public void given() {
        calculator = new Calculator();
    }

    @When("two numbers are passed as arguments")
    public void when() {
        result = calculator.sum(10L, 20L);
    }

    @Then("get sum of numbers")
    public void then() {
        System.out.println("result = " + result);
    }
}