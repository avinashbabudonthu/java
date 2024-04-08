package com.java.groups;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class TestClass3 {

    @Test(groups = {"group1"})
    public void test3_1() {
        log.info("test3_1");
    }

    @Test(groups = {"group2"})
    public void test3_2() {
        log.info("test3_2");
    }

}