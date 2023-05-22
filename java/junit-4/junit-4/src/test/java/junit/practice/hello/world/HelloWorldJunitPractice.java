package junit.practice.hello.world;

import junit.practice.model.Model1;

import org.junit.Assert;
import org.junit.Test;

public class HelloWorldJunitPractice {

	/**
	 * Junit Hello World
	 */
	@Test
	public void method1() {
		System.out.println("JunitPractice -> method1()");
		Model1 model1 = new Model1();
		String actual = model1.method1();

		Assert.assertEquals("Hello World", actual);
		Assert.assertNotEquals("Hello", actual);
	}

}