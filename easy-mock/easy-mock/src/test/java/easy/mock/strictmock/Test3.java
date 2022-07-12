package easy.mock.strictmock;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EasyMockRunner.class)
public class Test3 {

	private CalculateService3 calculateService3;
	private MathApplication3 mathApplication3;

	/**
	 * EasyMock.createStrictMock() creates a mock and also takes care of the order of method calls 
	 * that the mock is going to make in due course of its action
	 */
	@Before
	public void setup() {
		calculateService3 = EasyMock.createStrictMock(CalculateService3.class);
		mathApplication3 = new MathApplication3();
		mathApplication3.setCalculateService3(calculateService3);
	}

	@After
	public void teardown() {
		calculateService3 = null;
		mathApplication3 = null;
	}

	/**
	 * This test case will fail with below error
	 * 
	 * java.lang.AssertionError: 
	 * Unexpected method call CalculateService3.subtract(10 (int), 20 (int)):
	 * CalculateService3.add(10 (int), 20 (int)): expected: 1, actual: 0
	 */
	//	@Ignore
	@Test
	public void test1() {
		EasyMock.expect(calculateService3.add(10, 20)).andReturn(40);
		EasyMock.expect(calculateService3.subtract(10, 20)).andReturn(10);
		EasyMock.replay(calculateService3);

		mathApplication3.subtract(10, 20);
		mathApplication3.add(10, 20);

		EasyMock.verify(calculateService3);
	}

}
