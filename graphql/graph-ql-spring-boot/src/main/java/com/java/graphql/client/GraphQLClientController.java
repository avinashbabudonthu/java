package com.java.graphql.client;

import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/graphql/java/client")
public class GraphQLClientController {

    @Autowired
    private GraphQLWebClient graphQLWebClient;

    @GetMapping(value = "/test", produces = MediaType.TEXT_PLAIN_VALUE)
    public String test(){
        return "Testing Rest API";
    }

    // calling graphql query - studentRequest
    @GetMapping(value = "/studentRequest/{id}/{firstName}/{lastName}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String studentRequest(@PathVariable("id") Long id, @PathVariable("firstName") String firstName,
                                          @PathVariable("lastName") String lastName) {
        String queryString = "query{" +
                "    studentRequest(student: {" +
                "        id: " + id +
                "        firstName: " + firstName +
                "        lastName: " + lastName + 
                "    })" +
                "}";
        GraphQLRequest graphQLRequest = GraphQLRequest.builder().query(queryString).build();

        GraphQLResponse graphQLResponse = graphQLWebClient.post(graphQLRequest).block();
        String response = graphQLResponse.get("studentRequest", String.class);

        return response;
    }

}