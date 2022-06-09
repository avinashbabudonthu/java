package com.set;

@lombok.extern.slf4j.Slf4j
public class LinkedHashSetPractice {

    @org.junit.Test
    public void create(){
        java.util.Set<String> set = new java.util.LinkedHashSet<>();
        log.info("set={}", set);
    }

    @org.junit.Test
    public void add(){
        java.util.Set<String> set = new java.util.LinkedHashSet<>();
        set.add("1");
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("2"); // this value will be ignored because set does not allow duplicates
        log.info("set={}", set);
    }

    @org.junit.Test
    public void addAll(){
        java.util.Set<String> set1 = new java.util.LinkedHashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1.add("d");
        log.info("set1={}", set1);

        java.util.Set<String> set2 = new java.util.LinkedHashSet<>();
        set2.add("e");
        set2.add("f");
        set2.add("g");
        set2.add("h");
        log.info("set2={}", set2);

        set1.addAll(set2);
        log.info("after addAll - set1={}", set1);
    }

    @org.junit.Test
    public void remove(){
        java.util.Set<String> set1 = new java.util.LinkedHashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1.add("d");
        log.info("set1={}", set1);

        set1.remove("c");
        log.info("after remove set1={}", set1);

        java.util.Set<Integer> integerSet = new java.util.LinkedHashSet<>();
        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(3);
        integerSet.add(4);
        log.info("integerSet={}", integerSet);

        integerSet.remove(3);
        log.info("after remove integerSet={}", integerSet);
    }

    @org.junit.Test
    public void iterate(){
        java.util.Set<String> set1 = new java.util.LinkedHashSet<>();
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
        set1.stream().forEach(System.out::println); // method reference
    }

}
