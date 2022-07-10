package com.microservice2.rest.clients;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("microservice1")
public interface Microservice1FeignClient {

	@GetMapping(value = "/hello", produces = TEXT_PLAIN_VALUE)
	public String hello();

}