package com.versioning.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class StudentV2 {
    private String name;
    private Date courseStartDate;
    private String course;
}
