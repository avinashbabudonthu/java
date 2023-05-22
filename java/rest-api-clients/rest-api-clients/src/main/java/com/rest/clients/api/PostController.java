package com.rest.clients.api;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.rest.clients.model.Employee;
import com.rest.clients.util.Constants;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/post/v1")
public class PostController {

	@PostMapping(value = "/api-1", produces = MediaType.TEXT_PLAIN_VALUE)
	public String api1() {
		log.info("/post/v1/api-1");
		return "Hello World Post API 1";
	}

	@PostMapping(value = "/api-2", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public Employee api2(@RequestBody Employee employee) {
		log.info("employee={}", employee);
		employee.setCreateDate(new Date());
		return employee;
	}

	@SneakyThrows
	@PostMapping(value = "/api-3", consumes = { APPLICATION_FORM_URLENCODED_VALUE })
	public Employee api3(@RequestBody MultiValueMap<String, String> requestBodyMap) {
		log.info("employee={}", requestBodyMap);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_DD_MM_YYYY_HH_MM_A);
		Employee employee = Employee.builder().id(Long.valueOf(requestBodyMap.getFirst("id")))
				.name(requestBodyMap.getFirst("name"))
				.joiningDate(simpleDateFormat.parse(requestBodyMap.getFirst("joiningDate"))).createDate(new Date())
				.build();
		return employee;
	}

	@PostMapping(value = "/api-4", produces = APPLICATION_JSON_VALUE)
	public Employee api4() {
		WebClient webClient = WebClient.create("http://localhost:9000");
		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		multiValueMap.add("id", "1");
		multiValueMap.add("name", "name1");
		multiValueMap.add("joiningDate", "16-01-2020 04:41 PM");

		Mono<Employee> employeeMono = webClient.post().uri("/post/v1/api-3")
				.header("Content-Type", "application/x-www-form-urlencoded").syncBody(multiValueMap).retrieve()
				.bodyToMono(Employee.class);

		return employeeMono.block();
	}
}