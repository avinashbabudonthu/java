package com.gcp.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.data.spanner.repository.config.EnableSpannerRepositories;

@SpringBootApplication
@EnableSpannerRepositories
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
