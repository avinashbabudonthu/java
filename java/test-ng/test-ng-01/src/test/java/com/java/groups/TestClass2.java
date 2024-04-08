package com.java.groups;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class TestClass2 {

    @Test(groups = {"group1"})
    public void test2_1() {
        log.info("test2_1");
    }

    @Test(groups = {"group2"})
    public void test2_2() {
        log.info("test2_2");
    }
}
