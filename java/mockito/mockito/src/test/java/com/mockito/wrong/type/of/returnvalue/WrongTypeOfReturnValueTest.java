package com.mockito.wrong.type.of.returnvalue;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Why WrongTypeOfReturnValue Exception?
 * 
 * Well actually the issue in your code resides with the spy. Here is the explanation what's happening with your code.
 * 
 * A spy actually execute the real code by nature, so when calling "out.produce()" the expression is actually executed 
 * and return a real Product.
 * 
 * The constructor of Product takes the constructor arg "foo" which is a mock and it executes "f.getBar()". 
 * This invocation is recorded by mockito because this "foo" instance is a mock.
 * 
 * Then when you want to return "product", mockito raises the exception WrongTypeOfReturnValue saying that 
 * the recorded invocation "foo.getBar()" cannot return a Product.
 * 
 * If you want to mack a partial mock, which you should avoid if possible. 
 * You need to use the following style for spies, this way mockito can tell the spy instance to only record the 
 * invocation.
 * 
 * doReturn(mpoo).when(out).produce();
 * 
 * @author Avinash Babu Donthu
 *
 */
public class WrongTypeOfReturnValueTest {

	@Test
	public void whenThenReturnThrowsException() {
		Foo foo = Mockito.mock(Foo.class);
		Product product = Mockito.mock(Product.class);
		Outside outside = Mockito.spy(new Outside(foo));

		Mockito.when(outside.produce()).thenReturn(product);
	}

	@Test
	public void whenThenReturnSolution1() {
		Foo foo = Mockito.mock(Foo.class);
		Product product = Mockito.mock(Product.class);
		Outside outside = Mockito.spy(new Outside(foo));

		Mockito.doReturn(product).when(outside).produce();
	}
}
