package com.practive.java.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class ArrayListTest {

    @Test
    void createList() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        log.info("list1={}", list1);
    }

    @Test
    void immutableList() {
        List<String> list1 = List.of("b");
        log.info("list1={}", list1); // list1=[b]

        List<String> list2 = List.of("b", "c", "d");
        List<String> list3 = Collections.unmodifiableList(list2);
        log.info("list3 = {}", list3); // list3 = [b, c, d]
    }

    @Test
    void stringToList() {
        String inputString1 = "a,b,c,d,e";
        List<Object> list1 = stringToList(inputString1, ",");
        log.info("list1={}", list1); // list1=[a, b, c, d, e]

        String inputString2 = "f;g;h;i;j;k";
        List<Object> list2 = stringToList(inputString2, ";");
        log.info("list2={}", list2); // list2=[f, g, h, i, j, k]
    }

    private List<Object> stringToList(String inputString, String delimiter) {
        String[] strings = inputString.split(delimiter);
        return new ArrayList<>(Arrays.asList(strings));
    }

    @Test
    void listToString() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");
        String result1 = listToString(list1, ",");
        log.info("result1={}", result1); // result1=a,b,c,d,e

        String result2 = listToString(list1, ";");
        log.info("result2={}", result2); // result2=a;b;c;d;e
    }

    private String listToString(List<?> list, String delimiter) {
        List<String> stringList = list.stream().map(Object::toString).toList();
        return String.join(delimiter, stringList);
    }

    @Test
    void listToArray() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");
        String[] stringArray = list1.toArray(String[]::new);
        log.info("stringArray = {}", Arrays.deepToString(stringArray)); // stringArray = [a, b, c, d, e]

        Object[] objectArray = list1.toArray(Object[]::new);
        log.info("objectArray = {}", Arrays.deepToString(objectArray)); // objectArray = [a, b, c, d, e]
    }

    @Test
    void listToStringWithPrefixAndSuffix() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");
        String result1 = list1.stream().collect(Collectors.joining("','", "'", "'"));
        log.info("result1 = {}", result1); // result1 = 'a','b','c','d','e'
    }

    @Test
    void setToList() {
        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1.add("d");
        set1.add("e");
        log.info("set1={}", set1); // set1=[a, b, c, d, e]

        List<String> list1 = new ArrayList<>(set1);
        log.info("list1={}", list1); // list1=[a, b, c, d, e]
    }

    @Test
    public void removeIf() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        log.info("list={}", list);

        // list.removeIf(value -> "c".equalsIgnoreCase(value));
        list.removeIf("c"::equalsIgnoreCase);
        log.info("list={}", list);
    }

}