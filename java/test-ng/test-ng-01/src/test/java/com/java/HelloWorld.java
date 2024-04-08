package com.java;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class HelloWorld {

    @Test
    public void helloWorld() {
        log.info("Hello World");
    }

    @Test
    public void test1() {
        log.info("Test1");
    }

    @Test
    public void test2() {
        log.info("Test2");
    }

    @Test(enabled = false)
    public void test3() {
        log.info("Test3");
    }

    @Test
    public void test4() {
        log.info("Test4");
    }

}
