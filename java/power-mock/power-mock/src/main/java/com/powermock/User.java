package com.powermock;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class User {

    private String firstName;
    private String lastName;
    private String address;
}
