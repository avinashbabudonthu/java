package log4j.logging.controller;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AppController {

	@GetMapping(value = "/hello", produces = TEXT_PLAIN_VALUE)
	public String hello() {
		log.info("hello rest api");
		return "Hello World";
	}
}