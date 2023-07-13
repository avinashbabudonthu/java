package com.basics;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Course {

    private String name;
    private Double grade;

}
