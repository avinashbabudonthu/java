package springboot.data.jpa;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@ComponentScan(basePackages = { "springboot.data.jpa" })
@EnableJpaRepositories(basePackages = { "springboot.data.jpa" })
@EnableAutoConfiguration
public class DataJpaApp {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaApp.class, args);
	}

	// comment below method for multi tenant implementation
	@Bean
	@Qualifier("primaryDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Qualifier("objectMapper")
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}