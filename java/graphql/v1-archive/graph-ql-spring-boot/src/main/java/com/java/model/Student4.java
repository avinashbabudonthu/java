package com.java.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student4 {

    private Integer id;
    private String firstName;
    private String lastName;
    private List<Subject> subjects;
    private String exception;
    private Subject dataFetcherResult;
    private String selectionSet;
    private Integer age;
    private String customGraphQLContext;

}