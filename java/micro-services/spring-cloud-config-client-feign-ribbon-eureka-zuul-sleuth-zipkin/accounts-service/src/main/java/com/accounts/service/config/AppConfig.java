package com.accounts.service.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.accounts.service.model.AccountList;

import brave.sampler.Sampler;

@Configuration
@EnableConfigurationProperties({ AccountList.class })
public class AppConfig {

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}