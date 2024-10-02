package com.java.config;

import com.java.model.error.ErrorModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@SuppressWarnings("all")
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        // lambda
         String message = "Total error count: " + ex.getErrorCount() + ", " + ex.getFieldErrors().stream().map(fieldError -> {
             return fieldError.getField() + StringUtils.SPACE + fieldError.getDefaultMessage();
         }).collect(Collectors.joining(", "));

         // method reference
        // String message = "Total error count: " + ex.getErrorCount() + ", " + ex.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));

        ErrorModel errorModel = ErrorModel.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(message)
                .details(request.getDescription(false))
                .build();
        return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
    }

}