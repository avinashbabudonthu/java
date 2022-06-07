package read.properties.outside.jar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("file:${app.properties.file}")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}