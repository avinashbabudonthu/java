package com.ab.example0006;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Student0006 {

    private Long id;
    private String name;
    private List<Subject0006> subjects;

}
