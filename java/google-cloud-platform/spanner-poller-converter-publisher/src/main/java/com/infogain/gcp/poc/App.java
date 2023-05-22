package com.infogain.gcp.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@SpringBootApplication
@EnableScheduling
public class App {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(App.class, args);
	}

}