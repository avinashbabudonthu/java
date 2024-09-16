package com.java.step.defs;

import com.java.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class Calculator002StepDefinition {

    private Long num1;
    private Long num2;
    private Calculator calculator;
    private Long result;

    @Given("002 two numbers {long} and {long}")
    public void given(Long num1, Long num2) {
        this.num1 = num1;
        this.num2 = num2;
        calculator = new Calculator();
    }

    @When("002 two numbers are passed as arguments")
    public void when() {
        if(null != num1 && null != num2) {
            result = calculator.sum(num1, num2);
        } else {
            result = -1L;
        }
    }

    @Then("result is {long}")
    public void then(Long result) {
        Assertions.assertEquals(result, this.result);
    }
}
