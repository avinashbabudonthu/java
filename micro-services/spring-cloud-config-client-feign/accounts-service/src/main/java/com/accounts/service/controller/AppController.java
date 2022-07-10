package com.accounts.service.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.service.model.AccountList;
import com.accounts.service.rest.clients.AccountService;

@RestController
public class AppController {

	@Autowired
	private AccountService accountsService;

	@GetMapping(value = "/feign/accounts", produces = APPLICATION_JSON_VALUE)
	public AccountList findAllAccounts() {
		return accountsService.findAllAccounts();
	}
}
