package com.app.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.AccountModel;

@RestController
public class AppController {

	@Autowired
	private Environment environment;

	@GetMapping(value = "/accounts", produces = APPLICATION_JSON_VALUE)
	public List<AccountModel> findAccountModels() {
		String port = environment.getProperty("local.server.port");
		AccountModel accountModel1 = AccountModel.builder().id("1").name("jack").port(port).build();
		AccountModel accountModel2 = AccountModel.builder().id("2").name("jill").port(port).build();
		List<AccountModel> accountModelList = new ArrayList<>();
		accountModelList.add(accountModel1);
		accountModelList.add(accountModel2);

		return accountModelList;
	}
}
