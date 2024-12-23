package com.practice.java.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;

@Slf4j
public class LinkedHashSetTest {

    @Test
    public void create(){
        java.util.Set<String> set = new java.util.LinkedHashSet<>();
        log.info("set={}", set);
    }

    @Test
    public void add(){
        java.util.Set<String> set = new java.util.LinkedHashSet<>();
        set.add("1");
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("2"); // this value will be ignored because set does not allow duplicates
        log.info("set={}", set);
    }

    @Test
    public void addAll(){
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1.add("d");
        log.info("set1={}", set1);

        Set<String> set2 = new LinkedHashSet<>();
        set2.add("e");
        set2.add("f");
        set2.add("g");
        set2.add("h");
        log.info("set2={}", set2);

        set1.addAll(set2);
        log.info("after addAll - set1={}", set1);
    }

    @Test
    public void remove(){
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1.add("d");
        log.info("set1={}", set1);

        set1.remove("c");
        log.info("after remove set1={}", set1);

        Set<Integer> integerSet = new LinkedHashSet<>();
        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(3);
        integerSet.add(4);
        log.info("integerSet={}", integerSet);

        integerSet.remove(3);
        log.info("after remove integerSet={}", integerSet);
    }

    @Test
    public void iterate(){
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1.add("d");
        set1.add("e");
        set1.add("f");
        set1.add("a");

        log.info("{}", "iterate using for each loop");
        for(String str : set1){
            log.info("{}", str);
        }

        log.info("{}", "iterate using jdk8 collection streams");
        // set1.stream().forEach(value -> System.out.println(value)); // lambda
        set1.forEach(System.out::println); // method reference
    }

}
