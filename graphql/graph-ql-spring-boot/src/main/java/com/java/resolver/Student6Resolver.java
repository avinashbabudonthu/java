package com.java.resolver;

import com.java.model.Address;
import com.java.model.Student6;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Student6Resolver implements GraphQLResolver<Student6> {

    public Address address(Student6 student6, DataFetchingEnvironment environment){
        log.info("Getting student address");
        return Address.builder()
                .hNo("1234")
                .street("street")
                .city("city")
                .build();
    }

}