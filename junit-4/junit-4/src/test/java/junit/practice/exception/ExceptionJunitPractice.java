package junit.practice.exception;

import junit.practice.model.Model1;

import org.junit.Assert;
import org.junit.Test;

public class ExceptionJunitPractice {

	/**
	 * Test case for method throwing exception but no exception scenario
	 * @throws Exception
	 */
	@Test
	public void exceptionMethodNoExceptionCase() throws Exception {
		Model1 model1 = new Model1();
		String actual = model1.exceptionMethod(false);

		Assert.assertEquals("No Exception", actual);
	}

	/**
	 * Test case for method throwing an exception for exception throwing scenario
	 * @throws Exception
	 */
	@Test(expected = RuntimeException.class)
	public void exceptionMethodExceptionCase() throws Exception {
		Model1 model1 = new Model1();
		model1.exceptionMethod(true);
	}

}
