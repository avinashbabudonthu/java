package easy.mock.annotations;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(EasyMockRunner.class)
public class Test2 {

	// @TestSubject annotation is used to identify class which is going to use the mock object
	@TestSubject
	private MathApplication mathApplication = new MathApplication();

	//@Mock annotation is used to create the mock object to be injected
	@Mock
	private CalculateService calculateService;

	@Test
	public void add() {
		EasyMock.expect(calculateService.add(10, 20)).andReturn(40);
		EasyMock.expect(calculateService.add(12.12, 23.23)).andReturn(50.5);

		//activate the mock
		EasyMock.replay(calculateService);

		int result = mathApplication.add(10, 20);
		System.out.println("result: " + result);
		Assert.assertEquals(40, result);

		Double result2 = mathApplication.add(12.12, 23.23);
		System.out.println("result2: " + result2);
		Assert.assertEquals("50.5", result2.toString());
	}

	@Test
	public void subtract() {
		EasyMock.expect(calculateService.subtract(10, 20)).andReturn(10);

		//activate the mock
		EasyMock.replay(calculateService);

		int result = mathApplication.subtract(10, 20);
		System.out.println("result: " + result);
	}

	/**
	 * Run the test case 
	 * 1. comment calculateService.multiply(t1, t2) in MathApplication
	 * 2. uncomment calculateService.multiply(t1, t2) in MathApplication
	 */
	@Test
	public void verifyPractice() {
		EasyMock.expect(calculateService.multiply(12, 12)).andReturn(150);

		// activate the mock
		EasyMock.replay(calculateService);

		int result = mathApplication.multiply(12, 12);
		System.out.println("result: " + result);

		EasyMock.verify(calculateService);
	}

	@Test
	public void verifyNumberOfMethodCalls() {

		EasyMock.expect(calculateService.multiply(12, 12)).andReturn(150);

		// testing 2 times call
		/*EasyMock.expectLastCall().times(2);
		EasyMock.replay(calculateService);
		int result = mathApplication.multiply2(12, 12);
		System.out.println("results: " + result);*/

		// testing 3 times call
		EasyMock.expectLastCall().times(3);
		EasyMock.replay(calculateService);
		int result = mathApplication.multiply3(12, 12);
		System.out.println("results: " + result);
	}

	@Test
	public void timesMinMax() {
		EasyMock.expect(calculateService.multiply(12, 10)).andReturn(130);
		//expects between min and max calls
		EasyMock.expectLastCall().times(1, 3);
		EasyMock.replay(calculateService);

		int result = mathApplication.multiply3(12, 10);
		System.out.println("result: " + result);
	}

	@Test
	public void atLeastOnce() {
		EasyMock.expect(calculateService.multiply(12, 10)).andReturn(130);
		// expects at least one call
		EasyMock.expectLastCall().atLeastOnce();
		EasyMock.replay(calculateService);

		int result = mathApplication.multiply3(12, 10);
		System.out.println("result: " + result);
	}

	@Test
	public void anyTimes() {
		EasyMock.expect(calculateService.multiply(12, 10)).andReturn(130);
		// expects an unrestricted number of calls
		EasyMock.expectLastCall().anyTimes();
		EasyMock.replay(calculateService);

		int result = mathApplication.multiply3(12, 10);
		System.out.println("result: " + result);
	}

	@Test(expected = RuntimeException.class)
	public void exceptionHandling() {
		EasyMock.expect(calculateService.multiply(10, 10))
				.andThrow(new RuntimeException("Multiply is not implemented"));
		EasyMock.replay(calculateService);

		mathApplication.multiply(10, 10);
	}
}