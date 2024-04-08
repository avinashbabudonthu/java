package com.java.groups;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class TestClass1 {

    @Test(groups = {"group1"})
    public void test1_1() {
        log.info("test1_1");
    }
    @Test(groups = {"group2"})
    public void test1_2() {
        log.info("test1_2");
    }
}
