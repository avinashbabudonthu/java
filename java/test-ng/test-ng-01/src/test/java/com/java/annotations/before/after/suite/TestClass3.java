package com.java.annotations.before.after.suite;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Slf4j
public class TestClass3 {

    @BeforeSuite
    public void beforeSuite() {
        log.info("beforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        log.info("afterSuite");
    }

    @Test
    public void test3_1() {
        log.info("Test3_1. current object={}", this);
    }
}
