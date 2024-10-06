package com.java.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonFilter("StudentPropertyFilter")
public class User {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String encryptedPassword;
}