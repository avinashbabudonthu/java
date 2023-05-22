package mockito.argument.captor;

public class MathUtils {

	public int add(int i, int j) {
		return i + j;
	}

	public Employee printEmployee(String s1, String s2) {
		Employee employee = new Employee();
		employee.setFirstName(s1);
		employee.setLastName(s2);
		print(employee);
		return employee;
	}

	public void print(Employee employee) {
		System.out.println(employee.getFirstName() + " : " + employee.getLastName());
	}

}