package com.web.client;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import com.rest.clients.model.Employee;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class PostControllerTest {

	private WebClient createWebClient() {
		WebClient webClient = WebClient.create("http://localhost:9000");
		return webClient;
	}

	private WebClient createWebClientWithBuilder() {
		WebClient webClient = WebClient.builder().baseUrl("http://localhost:9000").build();
		return webClient;
	}

	@Test
	public void api3() {
		WebClient webClient = createWebClient();
		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		multiValueMap.add("id", "1");
		multiValueMap.add("name", "name1");
		multiValueMap.add("joiningDate", "16-01-2020 04:41 PM");

		Mono<Employee> employeeMono = webClient.post().uri("/post/v1/api-3")
				.header("Content-Type", "application/x-www-form-urlencoded").syncBody(multiValueMap).retrieve()
				.bodyToMono(Employee.class);

		Employee employee = employeeMono.block();

		log.info("employee={}", employee);
	}

}