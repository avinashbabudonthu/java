package com.microservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
// Any one of the below annotations can be used
@EnableEurekaClient
// @EnableDiscoveryClient 
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}