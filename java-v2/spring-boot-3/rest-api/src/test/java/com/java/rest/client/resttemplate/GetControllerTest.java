package com.java.rest.client.resttemplate;

import com.java.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Rest client with {@link org.springframework.web.client.RestTemplate}
 * to {@link com.java.controller.impl.GetControllerImpl}
 */
@Slf4j
public class GetControllerTest {

    @Test
    void helloWorld() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:9000/get/api/v1/hello-world", String.class);
        log.info("response={}", response);
    }

    @Test
    void studentsV1() {
        RestTemplate restTemplate = new RestTemplate();
        Student student = restTemplate.getForObject("http://localhost:9000/get/api/v1/students", Student.class);
        log.info("student={}", student);
    }

    @Test
    void studentsV2() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Student> student = restTemplate.getForEntity("http://localhost:9000/get/api/v2/students", Student.class);
        log.info("student={}", student);
    }

    @Test
    void studentsV3() {
        RestTemplate restTemplate = new RestTemplate();
        Student[] result1 = restTemplate.getForObject("http://localhost:9000/get/api/v3/students", Student[].class);
        log.info("result1={}", Arrays.deepToString(result1));

        ResponseEntity<List<Student>> result2 = restTemplate.exchange("http://localhost:9000/get/api/v3/students",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>(){});
        log.info("result2={}", result2.getBody());
    }

    @Test
    void studentsV4() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("name", "a");
        httpHeaders.add("book", "b1");

        HttpEntity<String> entity = new HttpEntity<>("parameters", httpHeaders);
        ResponseEntity<Student> responseEntity = restTemplate.exchange("http://localhost:9000/get/api/v4/students", HttpMethod.GET, entity, Student.class);
        log.info("responseEntity={}", responseEntity.getBody());
    }

    @Test
    void studentsV5() {
        RestTemplate restTemplate = new RestTemplate();
        Student student = restTemplate.getForObject("http://localhost:9000/get/api/v5/students?name=a&book=b1", Student.class);
        log.info("student={}", student);
    }

    @Test
    void studentsV6() {
        RestTemplate restTemplate = new RestTemplate();

        // example 1
        Student student1 = restTemplate.getForObject("http://localhost:9000/get/api/v6/students/a/b1", Student.class);
        log.info("student1={}", student1);

        // example 2
        String url = "http://localhost:9000/get/api/v6/students/{name}/{book}";
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("name", "a");
        pathParams.put("book", "b1");
        Student student2 = restTemplate.getForObject(url, Student.class, pathParams);
        log.info("student2={}", student2);
    }

    @Test
    void studentsV7() {
        RestTemplate restTemplate = new RestTemplate();
        Student[] result1 = restTemplate.getForObject("http://localhost:9000/get/api/v7/students?page=0&size=2&sort=asc", Student[].class);
        log.info("result1={}", Arrays.deepToString(result1));

        ResponseEntity<List<Student>> result2 = restTemplate.exchange("http://localhost:9000/get/api/v7/students?page=0&size=2&sort=asc",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>(){});
        log.info("result2={}", result2.getBody());
    }

}