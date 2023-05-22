package basic.authentication.authorization.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import basic.authentication.authorization.model.ResponseModel;
import basic.authentication.authorization.model.UserModel;
import basic.authentication.authorization.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/admin/v1", produces = APPLICATION_JSON_VALUE)
public class UsersController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/users", consumes = APPLICATION_JSON_VALUE)
	public UserModel saveUserModel(@RequestBody UserModel userModel) {
		log.info("Save USER-MODEL={}", userModel);
		return userService.saveUserModel(userModel);
	}

	@PatchMapping(value = "/users")
	public UserModel update(@RequestBody UserModel userModel) {
		log.info("update password, USER-MODEL={}", userModel);
		return userService.update(userModel);
	}

	@GetMapping(value = "/users")
	public ResponseModel findAllUserModels(@RequestParam(value = "page", required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size) {
		Sort sort = new Sort(Sort.Direction.ASC, "username");
		Pageable pageable = new PageRequest(page.orElse(0), size.orElse(Integer.MAX_VALUE), sort);
		return userService.findAllUserModels(pageable);
	}

	@Autowired
	private HttpServletRequest httpRequest;

	@GetMapping(value = "/headers", produces = MediaType.TEXT_PLAIN_VALUE)
	public String authorizationHeader() {
		return httpRequest.getHeader("Authorization");
		//		List<String> headers = httpHeaders.get("Authorization");
		//		return headers;
	}
}
