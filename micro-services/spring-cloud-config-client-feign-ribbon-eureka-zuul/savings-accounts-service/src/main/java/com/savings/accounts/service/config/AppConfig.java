package com.savings.accounts.service.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.savings.accounts.service.model.AccountList;

@Configuration
@EnableConfigurationProperties({ AccountList.class })
public class AppConfig {

}