package easy.mock.exception;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(EasyMockRunner.class)
public class Test4 {

	// @TestSubject annotation is used to identify class which is going to use the mock object
	@TestSubject
	private MathApplication4 mathApplication4 = new MathApplication4();

	// @Mock annotation is used to create the mock object to be injected
	@Mock
	private CalculateService4 calculateService4;

	@Test(expected = RuntimeException.class)
	public void add() {
		/*java.lang.Exception: Unexpected exception, expected<java.lang.RuntimeException> but was<java.lang.AssertionError>
		Caused by: java.lang.AssertionError: Unexpected method call CalculateService4.add(10 (int), 20 (int)):
				CalculateService4.add(isA(int), isA(int)): expected: 1, actual: 0*/
		/*EasyMock.expect(calculateService4.add(EasyMock.isA(int.class), EasyMock.isA(int.class))).andThrow(
				new RuntimeException("Exception thrown from test case"));*/

		// since add method is generic we need to pass Integer wrapper class for Class object.
		EasyMock.expect(calculateService4.add(EasyMock.isA(Integer.class), EasyMock.isA(Integer.class)))
				.andThrow(new RuntimeException("Exception thrown from test case"));

		EasyMock.replay(calculateService4);
		mathApplication4.add(10, 20);
	}
}
