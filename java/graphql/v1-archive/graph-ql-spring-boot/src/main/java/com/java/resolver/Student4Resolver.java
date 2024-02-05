package com.java.resolver;

import com.java.context.CustomGraphQLContext;
import com.java.exceptions.RuntimeException1;
import com.java.model.Student4;
import com.java.model.Subject;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
import graphql.schema.SelectedField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Slf4j
@Component
public class Student4Resolver implements GraphQLResolver<Student4> {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public List<Subject> subjects(Student4 student4, DataFetchingEnvironment dfe) {
        Subject subject1 = Subject.builder()
                .id(1)
                .name("Java")
                .marks(4.99D)
                .build();
        Subject subject2 = Subject.builder()
                .id(1)
                .name("GraphQL")
                .marks(4.98D)
                .build();
        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        return subjects;
    }

    public String exception(Student4 student4, DataFetchingEnvironment dfe) {
        log.info("Inside exception method");

        throw new RuntimeException1("Runtime exception 1");
    }

    public DataFetcherResult<Subject> dataFetcherResult(Student4 student4, DataFetchingEnvironment dfe) {
        return DataFetcherResult.<Subject>newResult()
                .data(Subject.builder()
                        .id(1)
                        .name("Java")
                        .build())
                .error(new GenericGraphQLError("Could not get marks details"))
                .build();
    }

    public CompletableFuture<List<Subject>> subjects2(Student4 student4, DataFetchingEnvironment dfe){
        return CompletableFuture.supplyAsync(
                () -> {
                    log.info("current thread={}", Thread.currentThread());
                    Subject subject1 = Subject.builder()
                            .id(1)
                            .name("Java")
                            .marks(4.99D)
                            .build();
                    Subject subject2 = Subject.builder()
                            .id(1)
                            .name("GraphQL")
                            .marks(4.98D)
                            .build();
                    List<Subject> subjects = new ArrayList<>();
                    subjects.add(subject1);
                    subjects.add(subject2);

                    return subjects;
                }, executorService);
    }

    public CompletableFuture<List<Subject>> subjects3(Student4 student4, DataFetchingEnvironment dfe){
        return CompletableFuture.supplyAsync(
                () -> {
                    log.info("current thread={}", Thread.currentThread());
                    Subject subject1 = Subject.builder()
                            .id(1)
                            .name("Spring Boot")
                            .marks(4.97D)
                            .build();
                    Subject subject2 = Subject.builder()
                            .id(1)
                            .name("Neptune")
                            .marks(4.96D)
                            .build();
                    List<Subject> subjects = new ArrayList<>();
                    subjects.add(subject1);
                    subjects.add(subject2);

                    return subjects;
                }, executorService);
    }

    public String selectionSet(Student4 student4, DataFetchingEnvironment environment){
        DataFetchingFieldSelectionSet dataFetchingFieldSelectionSet = environment.getSelectionSet();
        List<SelectedField> selectedFieldList = dataFetchingFieldSelectionSet.getFields();
        List<String> fields = selectedFieldList.stream().map(SelectedField::getName).collect(Collectors.toList());
        String fieldsCommaSeparated = fields.stream().collect(Collectors.joining(", "));
        return fieldsCommaSeparated;
    }

    public String customGraphQLContext(Student4 student4, DataFetchingEnvironment dataFetchingEnvironment){
        CustomGraphQLContext context = dataFetchingEnvironment.getContext();

        log.info("userId={}", context.getUserId());

        return "customGraphQLContext";
    }

}