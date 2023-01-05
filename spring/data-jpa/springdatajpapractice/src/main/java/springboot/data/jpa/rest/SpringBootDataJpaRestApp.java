package springboot.data.jpa.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "springboot.data.jpa" })
public class SpringBootDataJpaRestApp {

    public static void main(String[] args) {
	SpringApplication.run(SpringBootDataJpaRestApp.class, args);
    }

}
