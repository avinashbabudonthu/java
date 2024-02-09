package com.ab.example0007;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Student0007 {

    private Long id;
    private String name;
    private List<Subject0007> subjects;

}
