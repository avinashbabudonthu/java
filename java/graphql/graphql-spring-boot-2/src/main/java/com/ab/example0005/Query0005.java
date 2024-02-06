package com.ab.example0005;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class Query0005 implements GraphQLQueryResolver {

    public Response0005 example5(Request0005 request) {
        Long id = request.getId();
        String name = request.getName();
        Double number = request.getNumber();

        Response0005 response = new Response0005();
        response.setId(id);
        response.setName(name);
        response.setNumber(number);
        return response;
    }

}