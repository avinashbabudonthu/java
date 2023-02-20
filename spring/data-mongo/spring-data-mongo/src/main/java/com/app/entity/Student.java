package com.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    private List<Subject> subject;

    private Department department;

}
