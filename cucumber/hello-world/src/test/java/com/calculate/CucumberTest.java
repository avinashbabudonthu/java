package com.calculate;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty",
		"html:target/cucumber" }, snippets = SnippetType.CAMELCASE, features = "classpath:features")
public class CucumberTest {

}
