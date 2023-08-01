package com.lang3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;

@Slf4j
public class ToStringBuilderPractice {

    @Test
    public void reflectionToString(){
        Person person = Person.builder().name("jack").address("round street").build();
        log.info("person={}", person); // person=com.lang3.Person@62e136d3[name=jack,address=round street]
        String personString = ToStringBuilder.reflectionToString(person);
        log.info("personString={}", personString); // personString=com.lang3.Person@62e136d3[name=jack,address=round street]
    }
}
