package com.accounts.service.rest.clients;

import java.util.Map;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "zuul-gateway")
@RibbonClient(name = "savings-accounts-service")
public interface SavingsAccountsServiceRestClient {

	@GetMapping(value = "/savings-accounts-service/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> findAllAccounts();

	@GetMapping(value = "/savings-accounts-service/v2/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> accountsV2();
}