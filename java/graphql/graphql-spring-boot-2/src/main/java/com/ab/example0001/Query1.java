package com.ab.example0001;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class Query1 implements GraphQLQueryResolver {

    public String example1(Integer id, String name) {
        return "id = " + id + ", name = " + name;
    }

}