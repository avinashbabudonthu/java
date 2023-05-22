package com.microservice2.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice2.rest.clients.Microservice1FeignClient;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
public class AppController {

	@Autowired
	private Microservice1FeignClient microservice1FeignClient;

	@Autowired
	@Lazy
	private EurekaClient eurekaClient;

	@Value("${spring.application.name}")
	private String appName;

	@GetMapping(value = "/greet", produces = TEXT_PLAIN_VALUE)
	public String greeting() {
		String microservice1Response = microservice1FeignClient.hello();
		return String.format("Hello from %s, %s", eurekaClient.getApplication(appName).getName(),
				microservice1Response);
	}

	@GetMapping(value = "/microservice1-details", produces = APPLICATION_JSON_VALUE)
	public Map<String, Object> microservice1Details() {
		Application application = eurekaClient.getApplication("microservice1");
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String hostName = instanceInfo.getHostName();
		String appName = instanceInfo.getAppName();
		String healthCheckUrl = instanceInfo.getHealthCheckUrl();
		int port = instanceInfo.getPort();

		Map<String, Object> map = new HashMap<>();
		map.put("hostName", hostName);
		map.put("appName", appName);
		map.put("healthCheckUrl", healthCheckUrl);
		map.put("port", port);

		return map;
	}
}