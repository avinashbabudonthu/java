package com.versioning.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class StudentV1 {
    private String firstName;
    private String lastName;
    private Date courseStartDate;
    private String course;
}
