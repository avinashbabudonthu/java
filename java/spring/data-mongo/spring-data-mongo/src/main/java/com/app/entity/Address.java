package com.app.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "address")
public class Address {

    @Field(value = "hNo")
    private String hNo;

    @Field(value = "street")
    private String street;

}
