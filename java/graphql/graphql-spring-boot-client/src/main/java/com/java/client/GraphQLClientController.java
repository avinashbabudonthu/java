package com.java.client;

import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1")
public class GraphQLClientController {

    @Autowired
    private GraphQLWebClient graphQLWebClient;

    // calling graphql query - studentRequest
    @GetMapping(value = "/studentRequest/{id}/{firstName}/{lastName}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String studentRequest(@PathVariable("id") Long id, @PathVariable("firstName") String firstName,
                                 @PathVariable("lastName") String lastName) {
        String queryString2 = "query{" +
                "    studentRequest(student: {" +
                "        id: " + id + "" +
                "        firstName: \" " + firstName + "\"" +
                "        lastName: \"" + lastName + "\"" +
                "    })" +
                "}";
        GraphQLRequest graphQLRequest = GraphQLRequest.builder().query(queryString2).build();
        GraphQLResponse graphQLResponse = graphQLWebClient.post(graphQLRequest).block();
        String response = graphQLResponse.get("studentRequest", String.class);

        return response;
    }

    @GetMapping(value = "/studentRequest/variables/{id}/{firstName}/{lastName}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String studentRequestWithVariables(@PathVariable("id") Long id, @PathVariable("firstName") String firstName,
                                 @PathVariable("lastName") String lastName) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("id", id);
        variables.put("firstName", firstName);
        variables.put("lastName", lastName);

        String queryString2 = "query studentRequest($id: Int, $firstName: String, $lastName: String){" +
                "    studentRequest(student: {" +
                "        id: $id" +
                "        firstName: $firstName" +
                "        lastName: $lastName" +
                "    })" +
                "}";
        GraphQLRequest graphQLRequest = GraphQLRequest.builder().query(queryString2).variables(variables).build();
        GraphQLResponse graphQLResponse = graphQLWebClient.post(graphQLRequest).block();
        String response = graphQLResponse.get("studentRequest", String.class);

        return response;
    }

}