package data.jpa.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import data.jpa.entity.EmployeeEntity;
import data.jpa.repository.EmployeeEntityRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AppConfig {

	/**
	 * Create this bean only if DB is H2
	 * 
	 * @param employeeRepository
	 * @return
	 */
	@ConditionalOnProperty(name = { "spring.profiles.active" }, havingValue = "h2")
	@Bean
	public CommandLineRunner initialize(@Autowired EmployeeEntityRepository employeeRepository) {
		log.info("Insert only if db is h2");
		return (args) -> {
			employeeRepository.save(EmployeeEntity.builder().name("jack").build());
			employeeRepository.save(EmployeeEntity.builder().name("jill").build());
			employeeRepository.save(EmployeeEntity.builder().name("jim").build());

			List<EmployeeEntity> allEmployees = employeeRepository.findAll();
			allEmployees.stream().forEach(employee -> log.info("employee = {}", employee));
		};
	}
}
