package com.employee.service.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.employee.service.model.EmployeeList;

@Configuration
@EnableConfigurationProperties({ EmployeeList.class })
public class AppConfig {

}
