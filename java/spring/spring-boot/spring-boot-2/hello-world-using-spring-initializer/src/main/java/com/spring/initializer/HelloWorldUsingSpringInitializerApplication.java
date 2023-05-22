package com.spring.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldUsingSpringInitializerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldUsingSpringInitializerApplication.class, args);
		System.out.println("Hello Spring boot");
	}

}
