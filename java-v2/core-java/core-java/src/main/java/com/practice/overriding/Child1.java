package com.practice.overriding;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Child1 extends Parent1{

    @Override
    public void method2() {
        log.info("test2");
    }

}
