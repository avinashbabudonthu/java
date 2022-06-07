package com.web.client;

import org.junit.Test;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class GetControllerTest {

	private WebClient createWebClient() {
		WebClient webClient = WebClient.create("http://localhost:9000");
		return webClient;
	}

	private WebClient createWebClientWithBuilder() {
		WebClient webClient = WebClient.builder().baseUrl("http://localhost:9000").build();
		return webClient;
	}

	@Test
	public void api1() {
		// method 1
		WebClient webClient = createWebClient();
		Flux<String> response = webClient.get().uri("/get/v1/api-1").retrieve().bodyToFlux(String.class);
		log.info("response-1={}", response.blockFirst());

		// method 1
		WebClient webClient2 = createWebClientWithBuilder();
		Flux<String> response2 = webClient2.get().uri("/get/v1/api-1").retrieve().bodyToFlux(String.class);
		log.info("response-2={}", response2.blockFirst());
	}

}