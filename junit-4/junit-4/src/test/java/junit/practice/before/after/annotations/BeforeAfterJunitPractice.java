package junit.practice.before.after.annotations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BeforeAfterJunitPractice {

	@Before
	public void setup() {
		System.out.println("BeforeAfterJunitPractice -> setup()");
	}

	@After
	public void teardown() {
		System.out.println("BeforeAfterJunitPractice -> teardown()");
	}

	@Test
	public void beforeAfterMethod1() {
		System.out.println("BeforeAfterJunitPractice -> beforeAfterMethod1()");
	}

	@Test
	public void beforeAfterMethod2() {
		System.out.println("BeforeAfterJunitPractice -> beforeAfterMethod2()");
	}
}
