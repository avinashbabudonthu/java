package com.java.query;

import com.java.model.StudentRequest1;
import com.java.model.StudentResponse;
import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.Part;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class Mutation implements GraphQLMutationResolver {

    public StudentResponse createStudent(StudentRequest1 studentRequest1, DataFetchingEnvironment dfe){
        log.info("Inside createStudent method");
        return StudentResponse
                .builder()
                .id(Integer.valueOf(studentRequest1.getId().toString()))
                .firstName(studentRequest1.getFirstName())
                .lastName(studentRequest1.getLastName())
                .build();
    }

    public UUID fileUpload(DataFetchingEnvironment dataFetchingEnvironment){
        DefaultGraphQLServletContext graphQLServletContext = dataFetchingEnvironment.getContext();
        List<Part> parts = graphQLServletContext.getFileParts();
        parts.forEach(part -> log.info("file-name={}, size={}", part.getSubmittedFileName(), part.getSize()));

        // parts.get(0).getInputStream();
        // business logic

        return UUID.randomUUID();
    }

}