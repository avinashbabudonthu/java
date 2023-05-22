package com.hello.world.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
	public String hello() {
		return "Hello Spring Boot 2";
	}

	@GetMapping(value = "/hello2", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> requestParametersAsMap(@RequestParam Map<String, String> requestParameters) {
		System.out.println(requestParameters);
		return requestParameters;
	}
}
