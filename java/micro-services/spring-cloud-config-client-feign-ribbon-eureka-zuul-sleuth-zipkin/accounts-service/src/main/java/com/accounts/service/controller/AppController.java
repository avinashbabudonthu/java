package com.accounts.service.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.service.rest.clients.SavingsAccountsServiceRestClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/feign")
public class AppController {

	@Autowired
	private SavingsAccountsServiceRestClient savingsAccountsServiceRestClient;

	@Value("${spring.application.name}")
	private String appName;

	@GetMapping(value = "/test", produces = TEXT_PLAIN_VALUE)
	public String test() {
		log.info("{} - hello method", appName);
		return "hello world";
	}

	@GetMapping(value = "/accounts", produces = APPLICATION_JSON_VALUE)
	public Map<String, Object> findAllAccounts() {
		log.info("{} - findAllAccounts method", appName);
		return savingsAccountsServiceRestClient.findAllAccounts();
	}

	@GetMapping(value = "/v2/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> accountsV2() {
		log.info("{} - accountsV2 method", appName);
		return savingsAccountsServiceRestClient.accountsV2();
	}
}
