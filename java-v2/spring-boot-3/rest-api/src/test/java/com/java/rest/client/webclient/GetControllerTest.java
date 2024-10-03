package com.java.rest.client.webclient;

import com.java.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

/**
 * Rest client with {@link org.springframework.web.reactive.function.client.WebClient}
 * to {@link com.java.controller.impl.GetControllerImpl}
 *
 */
@Slf4j
public class GetControllerTest {

    @Test
    void createWebClient() {
        WebClient webClient1 = WebClient.create();
        // web-client=org.springframework.web.reactive.function.client.DefaultWebClient@4bff1903
        log.info("web-client={}", webClient1);

        WebClient webClient2 = WebClient.create("http://localhost:9000");
        // web-client=org.springframework.web.reactive.function.client.DefaultWebClient@50fe837a
        log.info("web-client={}", webClient2);

        WebClient webClient3 = WebClient.builder().baseUrl("http://localhost:9000").build();
        // web-client=org.springframework.web.reactive.function.client.DefaultWebClient@546ccad7
        log.info("web-client={}", webClient3);
    }

    @Test
    void helloWorld() {
        WebClient webClient = WebClient.create("http://localhost:9000");
        Flux<String> response = webClient.get().uri("/api/v1/hello-world")
                .retrieve().bodyToFlux(String.class);
        // response=MonoFlatMapMany
        log.info("response={}", response);
        // value=James Potter
        response.toStream().forEach(value -> log.info("value={}", value));
    }

    @Test
    void studentsV1() {
        WebClient webClient = WebClient.create("http://localhost:9000");
        Mono<Student> response = webClient.get().uri("/api/v1/students")
                .retrieve().bodyToMono(Student.class);
        Student student = response.block();
        log.info("student={}", student);
    }

    @Test
    void studentsV2() {
        WebClient webClient = WebClient.create("http://localhost:9000");
        Mono<ResponseEntity<Student>> response = webClient.get().uri("/api/v2/students")
                .retrieve().toEntity(Student.class);
        ResponseEntity<Student> responseEntity = response.block();
        Objects.requireNonNull(responseEntity);
        // status-code=200 OK, student=Student(id=508-14-3821, name=Ricardo Pfannerstill, book=Harry Potter and the Prisoner of Azkaban)
        log.info("status-code={}, student={}", responseEntity.getStatusCode(), responseEntity.getBody());
    }

    @Test
    void studentsV3() {
        WebClient webClient = WebClient.create("http://localhost:9000");
        List<Student> response = webClient.get().uri("/api/v3/students")
                .retrieve().bodyToFlux(Student.class).collectList().block();
        log.info("response={}", response);
    }

}