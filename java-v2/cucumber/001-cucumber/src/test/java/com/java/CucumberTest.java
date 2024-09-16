package com.java;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class CucumberTest {

    @Before("@calculator001")
    public void setup1() {
        System.out.println("Before calculator 001");
    }

    @Before("@calculator002")
    public void setup2() {
        System.out.println("Before calculator 002");
    }

    @After("@calculator001")
    public void teardown1() {
        System.out.println("After calculator 001");
    }

    @After("@calculator002")
    public void teardown2() {
        System.out.println("After calculator 002");
    }
}
