package com.spring.boot.activemq;

import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
public class AppConfig {

	/*@Bean
	public JmsListenerContainerFactory<?> queueFactory(ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer defaultJmsListenerContainerFactoryConfigurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		// This provides all boot's default to this factory, including the message converter
		defaultJmsListenerContainerFactoryConfigurer.configure(factory, connectionFactory);
		return factory;
	}
	
	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}*/
}