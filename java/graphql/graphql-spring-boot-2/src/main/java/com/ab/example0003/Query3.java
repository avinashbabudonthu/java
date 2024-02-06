package com.ab.example0003;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class Query3 implements GraphQLQueryResolver {

    public String example3(Request3 request3) {
        return request3.getId() + ", " + request3.getName() + ", " + request3.getNumber();
    }

}