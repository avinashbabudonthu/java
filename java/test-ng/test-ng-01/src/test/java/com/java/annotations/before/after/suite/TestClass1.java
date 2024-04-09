package com.java.annotations.before.after.suite;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class TestClass1 {

    @Test
    public void test1_1() {
        log.info("Test1_1. current object={}", this);
    }
}
