package junit.practice.time.out;

import org.junit.Test;

import junit.practice.model.Model1;

public class TimeoutJunitPractice {

	/**
	 * timeOutMethod will execute in 10 seconds but test method expects that method to be 
	 * finished in 5 seconds. So this test case will fail. 
	 */
	@Test(timeout = 1000 * 5)
	public void timeOutMethod() {
		Model1 model1 = new Model1();
		model1.timeOutMethod();
	}

	/**
	 * timeOutMethod will execute in 10 seconds but test method expects that method to be 
	 * finished in 15 seconds. So this test case will pass. 
	 */
	@Test(timeout = 1000 * 15)
	public void timeOutMethod2() {
		Model1 model1 = new Model1();
		model1.timeOutMethod();
	}
}