package com.ab.example0002;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class Query2 implements GraphQLQueryResolver {


    public String example2(Request2 request2) {
        return request2.getId() + ", " + request2.getName() + ", " + request2.getDoubleNumber();
    }

}
