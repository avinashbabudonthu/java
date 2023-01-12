package com.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicatePractice {

    /**
     * Output: [jim, john, jill]
     */
    @Test
    public void not(){
        List<String> list = Arrays.asList("jim", "john", "jill", "", " ");
        List<String> withoutBlanks = list.stream()
                // .filter(Predicate.not(str -> str.isBlank()))
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
        System.out.println(withoutBlanks);
    }
}
