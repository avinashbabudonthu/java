package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.app.repository")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
