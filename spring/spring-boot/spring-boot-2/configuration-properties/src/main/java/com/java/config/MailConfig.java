package com.java.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "mail")
public class MailConfig {

    private String emailId;
    private String userName;
    private String passWord;
    private String smtpHost;
    private Integer port;
    private String smtpUrl;

}