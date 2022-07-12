package junit.practice.beforeclass.afterclass.annotations;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeforeClassAfterClassJunitPractice {

	@BeforeClass
	public static void setupClass() {
		System.out.println("BeforeClassAfterClassJunitPractice -> setupClass()");
	}

	@AfterClass
	public static void teardownClass() {
		System.out.println("BeforeClassAfterClassJunitPractice -> teardownClass()");
	}

	@Test
	public void beforeAfterClassMethod1() {
		System.out.println("BeforeClassAfterClassJunitPractice -> beforeAfterClassMethod1()");
	}

	@Test
	public void beforeAfterClassMethod2() {
		System.out.println("BeforeClassAfterClassJunitPractice -> beforeAfterClassMethod2()");
	}

}