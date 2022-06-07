package read.properties.outside.jar.controller;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@Value("${app.desc:default-description}")
	private String appDescription;

	@GetMapping(value = "/app-desc", produces = TEXT_PLAIN_VALUE)
	public String getAppDescription() {
		return appDescription;
	}
}
