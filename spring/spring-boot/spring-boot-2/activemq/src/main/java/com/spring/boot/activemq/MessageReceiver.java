package com.spring.boot.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

	@JmsListener(destination = "queue-1"/*, containerFactory = "queueFactory"*/)
	public void receiveMessage(String message) {
		System.out.println("message received: " + message);
	}
}