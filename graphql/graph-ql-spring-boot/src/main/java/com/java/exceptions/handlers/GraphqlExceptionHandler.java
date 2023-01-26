package com.java.exceptions.handlers;

import com.java.exceptions.RuntimeException1;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@Component
public class GraphqlExceptionHandler {

    @ExceptionHandler(RuntimeException1.class)
    public ThrowableGraphQLError handleRuntimeException1(RuntimeException1 e){
        log.info("Inside exception handler");
        return new ThrowableGraphQLError(e);
    }
}