package com.mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;

import lombok.extern.slf4j.Slf4j;
import com.mockito.hello.world.HelloWorld;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class MockVoidMethods {

	@Mock
	private HelloWorld helloWorldMock;

	@Test
	public void add() {
		// HelloWorld helloWorldMock = Mockito.mock(HelloWorld.class);
		try {
			log.info("executing doThrow");
			Mockito.doThrow(new Exception()).when(helloWorldMock).add(Mockito.anyList(), Mockito.anyString());
			helloWorldMock.add(new ArrayList<>(), "jack");
		} catch (Exception e) {
			log.info("exception thrown");
		}
	}

	/**
	 * If method called more than once then mock each call
	 */
	@Test
	public void mockFollowUpMethodCalls() {
		ArrayList<String> list = new ArrayList<>();
		try {
			log.info("executing doThrow and doNothing");
			Mockito.doThrow(new RuntimeException()).doNothing().when(helloWorldMock).add(Mockito.anyList(),
					Mockito.anyString());
			helloWorldMock.add(list, "jack");
		} catch (Exception e) {
			log.info("calling method 2nd time");
			helloWorldMock.add(list, "jill");
			log.info("list={}", list);
		}
	}

	@Test
	public void returnCustomResult() {
		List<String> list = new ArrayList<>();
		Mockito.doAnswer((InvocationOnMock invocation) -> {
			Object[] args = invocation.getArguments();
			log.info("called with arguments: " + Arrays.toString(args));
			List<String> list2 = new ArrayList<>();
			list.add("jill");
			return list;
		}).when(helloWorldMock).add(Mockito.anyList(), Mockito.anyString());
		helloWorldMock.add(list, "jack");
		log.info("list:{}", list);
	}
}