package com.java.controller.impl;

import com.github.javafaker.Faker;
import com.java.controller.VersioningController;
import com.java.model.Student;
import com.java.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class VersioningControllerImpl implements VersioningController {

    private static final Faker FAKER = Faker.instance();

    @Override
    public Student urlVersioning1() {
        return Student.builder()
                .id("urlVersioning1")
                .name(FAKER.name().fullName())
                .book(FAKER.harryPotter().book())
                .build();
    }

    @Override
    public Student urlVersioning2() {
        return Student.builder()
                .id("urlVersioning2")
                .name(FAKER.name().fullName())
                .book(FAKER.harryPotter().book())
                .build();
    }

    @Override
    public Student requestParamVersioning1() {
        return Student.builder()
                .id("requestParamVersioning1")
                .name(FAKER.name().fullName())
                .book(FAKER.harryPotter().book())
                .build();
    }

    @Override
    public Student requestParamVersioning2() {
        return Student.builder()
                .id("requestParamVersioning2")
                .name(FAKER.name().fullName())
                .book(FAKER.harryPotter().book())
                .build();
    }

    @Override
    public Student headerVersioning1() {
        return Student.builder()
                .id("headerVersioning1")
                .name(FAKER.name().fullName())
                .book(FAKER.harryPotter().book())
                .build();
    }

    @Override
    public Student headerVersioning2() {
        return Student.builder()
                .id("headerVersioning2")
                .name(FAKER.name().fullName())
                .book(FAKER.harryPotter().book())
                .build();
    }

    @Override
    public Student mediaTypeVersioning1() {
        return Student.builder()
                .id("mediaTypeVersioning1")
                .name(FAKER.name().fullName())
                .book(FAKER.harryPotter().book())
                .build();
    }

    @Override
    public Student mediaTypeVersioning2() {
        return Student.builder()
                .id("mediaTypeVersioning2")
                .name(FAKER.name().fullName())
                .book(FAKER.harryPotter().book())
                .build();
    }
}
