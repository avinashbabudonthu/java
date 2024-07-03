package com.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // To start application with fixed port
        SpringApplication.run(Application.class, args);

//         To start application on random available port
//        SpringApplication.run(Application.class, "--server.port=0");
    }

}