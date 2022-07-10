package com.customer.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.model.CustomerListModel;

@RestController
public class CustomerController {

	@Autowired
	private CustomerListModel customerListModel;

	@GetMapping(value = "/customers", produces = APPLICATION_JSON_VALUE)
	public CustomerListModel findAllCustomers() {
		return customerListModel;
	}

}