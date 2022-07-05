package dependency.inject.setter.injection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "dependency.inject.setter.injection" })
public class AppConfig {

	@Bean
	public StudentService getStudentService() {
		return new StudentServiceImpl();
	}

	@Bean
	public StudentRepository getStudentRepository() {
		return new StudentRepositoryImpl();
	}
}
