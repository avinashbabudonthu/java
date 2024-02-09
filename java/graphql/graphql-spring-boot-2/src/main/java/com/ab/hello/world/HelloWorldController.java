package com.ab.hello.world;

import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class HelloWorldController {

    @Autowired
    private GraphQLWebClient graphQLWebClient;

    /**
     * Consumes graphql fullName query
     * {@link Query}
     * @return
     */
    @GetMapping(value = "/full-name", produces = TEXT_PLAIN_VALUE)
    public String fullName() {
        String query = "query fullName {\n" +
                "    fullName\n" +
                "}";
        GraphQLRequest request = GraphQLRequest.builder().query(query).build();
        GraphQLResponse graphQLResponse = graphQLWebClient.post(request).block();
        Objects.requireNonNull(graphQLResponse);
        return graphQLResponse.get("fullName", String.class);
    }
}