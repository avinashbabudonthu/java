package hello.world;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import hello.world.model.Address;
import hello.world.model.Employee;

/**
 * kmodule.xml - src/main/resources/META-INF/kmodule.xml
 * ksession name - EmployeeRules
 * 
 */
public class EmployeeRules {

	/**
	 * Rule - print employee and address objects
	 */
	@Test
	public void printAdressAndEmployeeObjects() {
		Address address = Address.builder().id("1").street("street1").build();
		Employee employee = Employee.builder().id("100").name("jim").addressId("1").build();

		KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
		StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession("EmployeeRules");
		KieSession kieSession = statelessKieSession.getKieBase().newKieSession();
		kieSession.insert(employee);
		kieSession.insert(address);

		kieSession.fireAllRules();
	}

	/**
	 * compere adress.id and employee.addressId
	 */
	@Test
	public void compareIds() {
		Address address = Address.builder().id("1").street("street1").build();
		Employee employee = Employee.builder().id("100").name("jim").addressId("1").build();

		KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
		StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession("EmployeeRules");
		KieSession kieSession = statelessKieSession.getKieBase().newKieSession();
		kieSession.insert(employee);
		kieSession.insert(address);

		kieSession.fireAllRules();
	}

	/**
	 * compare address.recordInsertDate before employee.recordInsertDate
	 */
	@Test
	public void compareDateBefore() {
		Date addressInsertDate = Date
				.from(LocalDate.now().minusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
		Address address = Address.builder().id("1").street("street1").recordInsertDate(addressInsertDate).build();

		Date employeeInsertDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		Employee employee = Employee.builder().id("100").name("jim").addressId("2").recordInsertDate(employeeInsertDate)
				.build();

		KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
		StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession("EmployeeRules");
		KieSession kieSession = statelessKieSession.getKieBase().newKieSession();
		kieSession.insert(employee);
		kieSession.insert(address);

		kieSession.fireAllRules();
	}

	/**
	 * compare address.recordInsertDate after employee.recordInsertDate
	 */
	@Test
	public void compareDateAfter() {
		Date addressInsertDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		Address address = Address.builder().id("1").street("street1").recordInsertDate(addressInsertDate).build();

		Date employeeInsertDate = Date
				.from(LocalDate.now().minusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
		Employee employee = Employee.builder().id("100").name("jim").addressId("2").recordInsertDate(employeeInsertDate)
				.build();

		KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
		StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession("EmployeeRules");
		KieSession kieSession = statelessKieSession.getKieBase().newKieSession();
		kieSession.insert(employee);
		kieSession.insert(address);

		kieSession.fireAllRules();
	}

}
