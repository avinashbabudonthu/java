package com.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CollectionsPractice {

    @Test
    public void toArray(){
        List<String> list = Arrays.asList("jim", "john", "jill", "adam", "ana");
        System.out.println(list); // [jim, john, jill, adam, ana]

        String[] strArray = list.toArray(String[]::new);
        /**
         * jim
         * john
         * jill
         * adam
         * ana
         */
        Arrays.stream(strArray).forEach(System.out::println);
    }
}
