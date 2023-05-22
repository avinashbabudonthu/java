package mockito.dependency;

import java.util.Arrays;
import java.util.List;

public class EmployeeDao {

	public List<String> getEmployeeNames() {
		List<String> names = Arrays.asList("jack", "jill", "johny", "depp");
		return names;
	}

	public List<String> getEmployeeNames(String name) {
		return Arrays.asList(name);
	}

}