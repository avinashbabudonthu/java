package command.line.runner.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import command.line.runner.model.Student;
import command.line.runner.service.StudentService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AppConfig {

	@Autowired
	private StudentService studentService;

	@Bean
	public CommandLineRunner initialize() {
		log.info("initializing");

		return (args) -> {
			Student student = studentService.findStudent();
			log.info("student id={}, name={}", student.getId(), student.getName());
		};
	}

}