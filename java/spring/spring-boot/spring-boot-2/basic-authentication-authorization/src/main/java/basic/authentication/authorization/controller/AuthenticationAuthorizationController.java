package basic.authentication.authorization.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import basic.authentication.authorization.model.UserModel;
import basic.authentication.authorization.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1", produces = APPLICATION_JSON_VALUE)
public class AuthenticationAuthorizationController {

	@Autowired
	private UserService userService;

	@GetMapping(value = { "/login" })
	public UserModel login() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		log.info("Login with USERNAME={}, ENABLED={}", username, user.isEnabled());

		return userService.findUserModelByUsername(username);
	}

	/*@PatchMapping(value = "/users/pwds")
	public UserModel changePassword(@RequestBody UserModel userModel) {
		log.info("update password, USER-MODEL={}", userModel);
		return userService.changePassword(userModel);
	}*/

}