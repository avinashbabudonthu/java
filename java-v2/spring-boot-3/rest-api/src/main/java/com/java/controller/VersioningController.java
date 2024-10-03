package com.java.controller;

import com.java.model.Student;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Versioning APIs")
@RequestMapping(value = "/versioning/api")
public interface VersioningController {

    @GetMapping(value = "/v1/students", produces = APPLICATION_JSON_VALUE)
    Student urlVersioning1();

    @GetMapping(value = "/v2/students", produces = APPLICATION_JSON_VALUE)
    Student urlVersioning2();

    @GetMapping(value = "/students", params = "VERSION=1", produces = APPLICATION_JSON_VALUE)
    Student requestParamVersioning1();

    @GetMapping(value = "/students", params = "VERSION=2", produces = APPLICATION_JSON_VALUE)
    Student requestParamVersioning2();

    @GetMapping(value = "/students", headers = "X-API-VERSION=1", produces = APPLICATION_JSON_VALUE)
    Student headerVersioning1();

    @GetMapping(value = "/students", headers = "X-API-VERSION=2", produces = APPLICATION_JSON_VALUE)
    Student headerVersioning2();

    @GetMapping(value = "/students", produces = "application/my-company-v1+json")
    Student mediaTypeVersioning1();

    @GetMapping(value = "/students", produces = "application/my-company-v2+json")
    Student mediaTypeVersioning2();
}
