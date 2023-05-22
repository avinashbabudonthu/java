package com.accounts.service.rest.clients;

import java.util.Map;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "savings-accounts-service")
@RibbonClient(name = "savings-accounts-service")
public interface AccountService {

	@GetMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> findAllAccounts();
}