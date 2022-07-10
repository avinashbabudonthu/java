package com.savings.accounts.service.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.savings.accounts.service.model.Account;
import com.savings.accounts.service.model.AccountList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AppController {

	@Autowired
	private AccountList accountList;

	@Autowired
	private Environment environment;

	@Value("${spring.application.name}")
	private String appName;

	@GetMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> accounts() {
		log.info("{} - accounts() method", appName);
		Map<String, Object> result = new HashMap<>();
		Account account1 = Account.builder().number("1").name("jill").build();
		Account account2 = Account.builder().number("2").name("james").build();
		List<Account> accountList = new ArrayList<>();
		accountList.add(account1);
		accountList.add(account2);
		result.put("accountList", accountList);
		result.put("port", environment.getProperty("local.server.port"));
		return result;
	}

	@GetMapping(value = "/v2/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> accountsV2() {
		log.info("{} - accountsV2 method", appName);
		Map<String, Object> result = new HashMap<>();
		result.put("accountList", accountList);
		result.put("port", environment.getProperty("local.server.port"));
		return result;
	}
}