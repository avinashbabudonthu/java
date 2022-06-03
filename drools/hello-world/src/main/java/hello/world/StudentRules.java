package hello.world;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import hello.world.model.Student;

/**
 * kmodule.xml - src/main/resources/META-INF/kmodule.xml
 * ksession name - StudentRules
 *
 */
public class StudentRules {

	private static List<Student> studentList = new ArrayList<>();

	static {
		studentList.add(Student.builder().name("jim").age(22).build());
		studentList.add(Student.builder().name("jill").age(20).build());
		studentList.add(Student.builder().name("jack").age(13).build());
		studentList.add(Student.builder().name("john").age(14).build());
		studentList.add(Student.builder().age(14).build());

		Date date = Date.from(LocalDate.now().plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
		studentList.add(Student.builder().name("jane").age(14).joiningDate(date).build());

		Date date2 = Date.from(LocalDate.now().minusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
		studentList.add(Student.builder().name("smith").age(14).joiningDate(date2).build());
	}

	/*
	 * is student name present
	 */
	@Test
	public void isStudentPresent() {
		KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
		StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession("StudentRules");
		statelessKieSession.setGlobal("studentRules", new StudentRules());
		statelessKieSession.execute(studentList);

	}

	/*
	 * Age greater than 21
	 */
	@Test
	public void ageGreaterThan21() {
		KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
		StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession("StudentRules");
		statelessKieSession.setGlobal("studentRules", new StudentRules());
		statelessKieSession.execute(studentList);

	}

	/*
	 * Age less than 15
	 */
	@Test
	public void ageLessThan15() {
		KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
		StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession("StudentRules");
		statelessKieSession.setGlobal("studentRules", new StudentRules());
		statelessKieSession.execute(studentList);

	}

	/*
	 * Correct Age
	 */
	@Test
	public void isCorrectAge() {
		KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
		StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession("StudentRules");
		statelessKieSession.setGlobal("studentRules", new StudentRules());
		statelessKieSession.execute(studentList);

	}

	/*
	 * is student name is john
	 */
	@Test
	public void isStudentNameJohn() {
		KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
		StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession("StudentRules");
		statelessKieSession.execute(studentList);

	}

	/*
	 * and condition - check for student name and age
	 */
	@Test
	public void andCondition() {
		KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
		StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession("StudentRules");
		statelessKieSession.execute(studentList);

	}

	/*
	 * date before validation
	 */
	@Test
	public void dateBeforeValidation() {
		KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
		StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession("StudentRules");
		statelessKieSession.execute(studentList);

	}

	/*
	 * date after validation
	 */
	@Test
	public void dateAfterValidation() {
		KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
		StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession("StudentRules");
		statelessKieSession.execute(studentList);

	}

	public void printMessage(String... messages) {
		String str = String.join(", ", messages);
		System.out.println(str);
	}
}
