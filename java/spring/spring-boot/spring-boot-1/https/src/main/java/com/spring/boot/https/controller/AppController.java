package com.spring.boot.https.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping("/secured")
	public String secured() {
		return "Hello World Secured";
	}
}