package com.spring.boot.activemq;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(App.class, args);

		JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
		jmsTemplate.convertAndSend("queue-1", "Message " + new Date());
	}

}