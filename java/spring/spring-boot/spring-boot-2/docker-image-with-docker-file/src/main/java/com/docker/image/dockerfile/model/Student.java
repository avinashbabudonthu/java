package com.docker.image.dockerfile.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private String name;
    private Double grade;
    private Date joiningDate;

}
