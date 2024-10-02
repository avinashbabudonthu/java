package com.java.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@Tag(name = "I18N APIs")
@RequestMapping(value = "/i18n/api")
public interface I18NController {

    @GetMapping(value = "/v1/hello-world", produces = TEXT_PLAIN_VALUE)
    String helloWorld();

    @GetMapping(value = "/v1/hello-world/{name}", produces = TEXT_PLAIN_VALUE)
    String helloWorldWithName(@PathVariable("name") String name);
}