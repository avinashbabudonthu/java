package com.student.service.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.student.service.model.StudentList;

@Configuration
@EnableConfigurationProperties({ StudentList.class })
public class AppConfig {

}
