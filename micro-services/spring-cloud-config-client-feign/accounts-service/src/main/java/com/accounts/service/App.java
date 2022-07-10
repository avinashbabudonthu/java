package com.accounts.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.accounts.service")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}