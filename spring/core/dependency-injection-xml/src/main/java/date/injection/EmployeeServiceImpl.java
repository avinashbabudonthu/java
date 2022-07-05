package date.injection;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Setter
	private EmployeeRepository employeeRepository;

	@Override
	public Employee findEmployee() {
		log.info("find employee");
		return employeeRepository.findEmployee();
	}
}
