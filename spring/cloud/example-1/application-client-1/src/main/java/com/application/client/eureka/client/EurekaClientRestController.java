package com.application.client.eureka.client;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EurekaClientRestController {

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@GetMapping(value = "/eureka-client/hello", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<String> hello() {

		// 1st argument - spring.application.name property in application-service/application.properties
		// 2nd argument - whether or not this is secured request
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("application-service", false);
		String baseUrl = instanceInfo.getHomePageUrl();
		String restEndPoint = baseUrl + "hello";
		log.info("base-url={}, rest end-point={}", baseUrl, restEndPoint);

		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<String> response = restTemplate.exchange(restEndPoint, HttpMethod.GET, null, String.class);

		return response;
	}
}
