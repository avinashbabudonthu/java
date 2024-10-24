package com.java;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseStatusExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public Mono<ResponseEntity<String>> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException,
                                                                        ServerWebExchange serverWebExchange) {
        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(resourceNotFoundException.getMessage()));
    }

    @ExceptionHandler(BadRequestException.class)
    public Mono<ResponseEntity<String>> handleBadRequestException(BadRequestException badRequestException,
                                                                        ServerWebExchange serverWebExchange) {
        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badRequestException.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<String>> handleGenericException(Exception resourceNotFoundException,
                                                                        ServerWebExchange serverWebExchange) {
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resourceNotFoundException.getMessage()));
    }

}