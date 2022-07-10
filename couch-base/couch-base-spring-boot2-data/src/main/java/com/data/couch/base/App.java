package com.data.couch.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableCouchbaseRepositories(basePackages = {"com.data.couch.base"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
