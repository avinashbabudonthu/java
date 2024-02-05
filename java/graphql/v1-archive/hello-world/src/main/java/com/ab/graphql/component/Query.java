package com.ab.graphql.component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    public String helloWorld() {
        return "Hello World";
    }

    public String helloWorld2() {
        return "Hello World2";
    }

}