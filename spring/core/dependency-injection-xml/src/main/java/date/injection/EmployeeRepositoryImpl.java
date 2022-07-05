package date.injection;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Setter
	private Employee employee;

	@Override
	public Employee findEmployee() {
		log.info("find employee");
		return employee;
	}
}
