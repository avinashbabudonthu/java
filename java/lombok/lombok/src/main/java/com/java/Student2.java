package com.java;

import lombok.Data;
import lombok.NonNull;

@Data
public class Student2 {

    @NonNull
    private Long id;
    private String name;

    public void print(@NonNull String course){
        System.out.println(course);
    }
}
