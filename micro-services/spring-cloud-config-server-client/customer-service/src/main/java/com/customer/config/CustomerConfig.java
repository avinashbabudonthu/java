package com.customer.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.customer.model.CustomerListModel;

@Configuration
@EnableConfigurationProperties({ CustomerListModel.class })
public class CustomerConfig {
}