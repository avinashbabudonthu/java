package com.java.annotations.before.after.suite;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class TestClass2 {

    @Test
    public void test2_1() {
        log.info("Test2_1. current object={}", this);
    }
}
