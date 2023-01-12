package com.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambdas {

    /**
     * Output:
     * JIM->JOHN->JILL->ADAM->ANA
     * 
     */
    @Test
    public void localVariable(){
        List<String> list = Arrays.asList("jim", "john", "jill", "adam", "ana");
        String resultString = list.stream()
                .map((var str) -> str.toUpperCase())
                .collect(Collectors.joining("->"));
        System.out.println(resultString);
    }
}
