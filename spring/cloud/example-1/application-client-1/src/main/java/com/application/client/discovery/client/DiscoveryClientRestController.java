package com.application.client.discovery.client;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DiscoveryClientRestController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@GetMapping(value = "/discovery-client/hello", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<String> hello() {

		// 1st argument - spring.application.name property in application-service/application.properties
		List<ServiceInstance> instanceInfoList = discoveryClient.getInstances("application-service");
		String baseUrl = instanceInfoList.stream().findFirst().get().getUri().toString();
		String restEndPoint = baseUrl + "hello";
		log.info("base-url={}, rest end-point={}", baseUrl, restEndPoint);

		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<String> response = restTemplate.exchange(restEndPoint, HttpMethod.GET, null, String.class);

		return response;
	}
}
