package com.accounts.service.rest.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import com.accounts.service.model.AccountList;

@FeignClient(name = "savings-accounts-service", url = "localhost:9000")
public interface AccountService {

	@GetMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
	public AccountList findAllAccounts();
}