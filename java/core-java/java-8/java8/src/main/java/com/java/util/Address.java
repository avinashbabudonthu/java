package com.java.util;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    private String hNo;
    private String street;

}