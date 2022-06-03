package com.lang3;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ToStringBuilderPractice {

    @Test
    public void append(){
        Person person = Person.builder().name("jack").address("round street").build();
        log.info("person={}", person);
    }
}
