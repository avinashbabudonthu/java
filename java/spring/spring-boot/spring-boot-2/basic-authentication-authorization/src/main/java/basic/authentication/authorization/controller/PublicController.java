package basic.authentication.authorization.controller;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/v1")
public class PublicController {

	@GetMapping(value = "/hello", produces = TEXT_PLAIN_VALUE)
	public String hello() {
		return "Hello World";
	}
}
