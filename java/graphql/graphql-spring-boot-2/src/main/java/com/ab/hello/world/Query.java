package com.ab.hello.world;

import com.github.javafaker.Faker;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    public String fullName() {
        return Faker.instance().name().fullName();
    }

}