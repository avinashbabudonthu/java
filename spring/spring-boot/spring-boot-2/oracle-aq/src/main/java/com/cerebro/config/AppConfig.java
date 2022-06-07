package com.cerebro.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	/*@Bean
	public QueueConnectionFactory connectionFactory() throws Exception {
		OracleServiceInfo serviceInfo = (OracleServiceInfo) this.cloud().getServiceInfo(NAME_PRIMARY_DS);
		Properties info = new Properties();
		String url = serviceInfo.getJdbcUrl();
		info.put("driver-name", "oracle.jdbc.OracleDriver");
		info.put("user", serviceInfo.getUserName());
		info.put("password", serviceInfo.getPassword());
		return oracle.jms.AQjmsFactory.getQueueConnectionFactory(url, info);
	}
	
	@Bean
	public JmsTemplate jmsTemplate() throws Exception {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory());
		return jmsTemplate;
	}*/

}