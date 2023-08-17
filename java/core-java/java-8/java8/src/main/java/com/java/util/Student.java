package com.java.util;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {

    private int id;
    private String name;
    private String address;

}
