package date.injection;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

	@Test
	public void student() {
		try (AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"date.injection/applicationContext.xml")) {
			StudentService studentService = applicationContext.getBean("studentServiceImpl", StudentService.class);
			Student student = studentService.findStudent();
			log.info("student={}", student);
		}
	}

	@Test
	public void employee() {
		try (AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"date.injection/applicationContext.xml")) {
			EmployeeService employeeService = applicationContext.getBean("employeeServiceImpl", EmployeeService.class);
			Employee employee = employeeService.findEmployee();
			log.info("employee={}", employee);
		}
	}
}