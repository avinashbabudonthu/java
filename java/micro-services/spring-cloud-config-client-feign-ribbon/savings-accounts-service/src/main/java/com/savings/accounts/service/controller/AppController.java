package com.savings.accounts.service.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.savings.accounts.service.model.AccountList;

@RestController
public class AppController {

	@Autowired
	private AccountList accountList;

	@Autowired
	private Environment environment;

	@GetMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> test() {
		Map<String, Object> result = new HashMap<>();
		result.put("accountList", accountList);
		result.put("port", environment.getProperty("local.server.port"));
		return result;
	}
}