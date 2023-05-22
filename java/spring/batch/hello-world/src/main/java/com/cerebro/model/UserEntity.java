package com.cerebro.model;

import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class UserEntity {

    @javax.persistence.Id
    @javax.persistence.Column(name = "id")
    private String id;

    @javax.persistence.Column(name = "name")
    private String name;

    @javax.persistence.Column(name = "dept")
    private String dept;

    @javax.persistence.Column(name = "salary")
    private Long salary;
}