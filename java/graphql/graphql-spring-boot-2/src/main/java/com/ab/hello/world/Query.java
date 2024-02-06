package com.ab.hello.world;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    public String fullName() {
        return Faker.instance().name().fullName();
    }

}