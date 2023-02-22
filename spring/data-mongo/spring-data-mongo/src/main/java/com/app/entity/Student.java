package com.app.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "student")
public class Student {

    @Id
    private String id;

    @Field(value = "name")
    private String name;

    @Field(value = "mail")
    private String email;

    @Field(value = "subjects")
    private List<Subject> subjects;

    private Department department;

}
