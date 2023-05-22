package read.yaml.outside.jar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import read.yaml.outside.jar.config.YamlPropertySourceFactory;

@SpringBootApplication
@PropertySource(value = "file:${app.properties.file}", factory = YamlPropertySourceFactory.class)
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
