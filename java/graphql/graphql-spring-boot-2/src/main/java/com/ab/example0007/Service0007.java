package com.ab.example0007;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Service0007 {

    private final Map<Long, List<Subject0007>> subjectsMap = new HashMap<>();

    public Service0007() {
        List<Subject0007> subjects1 = new ArrayList<>();
        subjects1.add(Subject0007.builder().id(100L).name("Java").build());
        subjects1.add(Subject0007.builder().id(101L).name("GraphQL").build());
        subjectsMap.put(1L, subjects1);

        List<Subject0007> subjects2 = new ArrayList<>();
        subjects2.add(Subject0007.builder().id(102L).name("Spring Boot").build());
        subjects2.add(Subject0007.builder().id(103L).name("Docker").build());
        subjectsMap.put(2L, subjects2);
    }

    public List<Subject0007> findSubjectByStudentId(Long studentId) {
        return subjectsMap.get(studentId);
    }

}