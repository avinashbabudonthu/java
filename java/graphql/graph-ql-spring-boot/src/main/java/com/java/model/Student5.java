package com.java.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student5 {

    private Integer id;
    private String firstName;
    private String lastName;
    private List<Subject> subjects;

}