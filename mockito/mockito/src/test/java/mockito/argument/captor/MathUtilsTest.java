package mockito.argument.captor;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MathUtilsTest {

	@Test
	public void add() {
		MathUtils mathUtils = Mockito.mock(MathUtils.class);
		Mockito.when(mathUtils.add(1, 1)).thenReturn(2);

		ArgumentCaptor<Integer> integerArgCaptor = ArgumentCaptor.forClass(Integer.class);

		Assert.assertEquals(2, mathUtils.add(1, 1));

		Mockito.verify(mathUtils).add(integerArgCaptor.capture(), integerArgCaptor.capture());
		List<Integer> addMethodArguments = integerArgCaptor.getAllValues();
		System.out.println("addMethodArguments: " + addMethodArguments);
		Assert.assertEquals(Arrays.asList(1, 1), addMethodArguments);
	}

	@Test
	public void printEmployee() {
		try {
			MathUtils mathUtilsMock = Mockito.mock(MathUtils.class);
			String firstName = "jack";
			String lastName = "john";

			Mockito.doCallRealMethod().when(mathUtilsMock).printEmployee(firstName, lastName);
			mathUtilsMock.printEmployee(firstName, lastName);

			ArgumentCaptor<Employee> employeeArgumentCaptor = ArgumentCaptor.forClass(Employee.class);
			Mockito.verify(mathUtilsMock).print(employeeArgumentCaptor.capture());

			Employee employee2 = employeeArgumentCaptor.getValue();
			System.out.println(employee2.getFirstName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}