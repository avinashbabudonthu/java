package com.ab.example0001;

import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class Example0001Controller {

    @Autowired
    private GraphQLWebClient graphQLWebClient;

    @GetMapping(value = "/v1/example1/{id}/{name}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String example1(@PathVariable("id") Long id, @PathVariable("name") String name) {
        String query = "query example1 {\n" +
                "    example1(id: 1, name: \"Jim\")\n" +
                "}";
        GraphQLRequest request = GraphQLRequest.builder().query(query).build();
        GraphQLResponse graphQLResponse = graphQLWebClient.post(request).block();
        Objects.requireNonNull(graphQLResponse);
        return graphQLResponse.get("example1", String.class);
    }

    @GetMapping(value = "/v2/example1/{id}/{name}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String example1WithVariables(@PathVariable("id") Long id, @PathVariable("name") String name) {
        String query = "query example1 ($id1: Int, $name1: String) {\n" +
                "    example1(id: $id1, name: $name1)\n" +
                "}";

        Map<String, Object> variables = new HashMap<>();
        variables.put("id1", id);
        variables.put("name1", name);

        GraphQLRequest request = GraphQLRequest.builder().query(query).variables(variables).build();
        GraphQLResponse graphQLResponse = graphQLWebClient.post(request).block();
        Objects.requireNonNull(graphQLResponse);
        return graphQLResponse.get("example1", String.class);
    }

}