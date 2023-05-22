package com.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;
import java.util.WeakHashMap;

@Slf4j
public class WeakHashMapPractice {

    @Test
    public void createWeakHashMap(){
        Map<Student, Student> studentMap = new WeakHashMap<>();
        studentMap.put(new Student(), new Student());

        log.info("studentMap={}", studentMap);
    }

}
