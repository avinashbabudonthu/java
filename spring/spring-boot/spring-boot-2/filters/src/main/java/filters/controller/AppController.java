package filters.controller;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping(value = "/api/v1/1", produces = TEXT_PLAIN_VALUE)
	public String apiOne() {
		return "Hello World";
	}

	@GetMapping(value = "/api/v2/1", produces = TEXT_PLAIN_VALUE)
	public String apiTwo() {
		return "Hello World";
	}

	@GetMapping(value = "/api/v3/1", produces = TEXT_PLAIN_VALUE)
	public String apiThree() {
		return "Hello World";
	}
}
