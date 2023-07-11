package com.mockito.hello.world;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class HelloWorldTest {

	/**
	 * Testing HelloWorld class hello method with any string value
	 */
	@Test
	public void testHello() {
		HelloWorld helloWorld = Mockito.mock(HelloWorld.class);
		Mockito.when(helloWorld.hello(Mockito.anyString())).thenReturn("Hello Jack");
		Assert.assertEquals("Hello Jack", helloWorld.hello("Ventura"));
	}

	/**
	 * Testing HelloWorld class hello method with specific string value
	 */
	@Test
	public void testHelloWithSpecificString() {
		HelloWorld helloWorld = Mockito.mock(HelloWorld.class);
		Mockito.when(helloWorld.hello("Ventura")).thenReturn("Hello Jack");
		Assert.assertEquals("Hello Jack", helloWorld.hello("Ventura"));
	}

	/**
	 * Testing HelloWorld class sum method with specific int values
	 */
	@Test
	public void testSumWithSpefictInts() {
		HelloWorld helloWorld = Mockito.mock(HelloWorld.class);
		Mockito.when(helloWorld.sum(10, 30)).thenReturn(60);
		Assert.assertEquals(60, helloWorld.sum(10, 30));
	}

	/**
	 * Testing HelloWorld class sum method with any int values
	 */
	@Test
	public void testSumWithAnyInts() {
		HelloWorld helloWorld = Mockito.mock(HelloWorld.class);
		Mockito.when(helloWorld.sum(Mockito.anyInt(), Mockito.anyInt())).thenReturn(20);
		Assert.assertEquals(20, helloWorld.sum(10, 20));
	}

	/**
	 * when using mock object:
	 * when(mock.method()).thenReturn(foo).thenReturn(bar).thenThrow(new Exception("test"));
	 * when( method-call ).thenReturn( value1, value2, value3 );
	 * 
	 * when using spy or mocking a void method
	 * doReturn(foo).doReturn(bar).doThrow(new Exception("Test").when(mock).method();
	 */
	@Test
	public void returnDifferentValuesOnMultipleInvocations() {
		// Mock object
		HelloWorld helloWorld = Mockito.mock(HelloWorld.class);
		// Mockito.when(helloWorld.sum(Mockito.anyInt(), Mockito.anyInt())).thenReturn(10, 20, 30);
		Mockito.when(helloWorld.sum(Mockito.anyInt(), Mockito.anyInt())).thenReturn(10).thenReturn(20).thenReturn(30);
		int result1 = helloWorld.sum(1, 2);
		int result2 = helloWorld.sum(3, 4);
		int result3 = helloWorld.sum(5, 6);
		log.info("result1={}, result2={}, result3={}", result1, result2, result3);

		HelloWorld helloWorldspy = Mockito.spy(HelloWorld.class);
		// Mockito.doReturn(10, 20, 30).when(helloWorldspy).sum(Mockito.anyInt(), Mockito.anyInt());
		Mockito.doReturn(10).doReturn(20).doReturn(30).when(helloWorldspy).sum(Mockito.anyInt(), Mockito.anyInt());
		int result4 = helloWorldspy.sum(1, 2);
		int result5 = helloWorldspy.sum(3, 4);
		int result6 = helloWorldspy.sum(5, 6);
		log.info("result4={}, result5={}, result6={}", result4, result5, result6);
	}
}
