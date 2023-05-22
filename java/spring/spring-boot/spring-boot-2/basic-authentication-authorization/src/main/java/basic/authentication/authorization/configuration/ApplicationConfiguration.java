package basic.authentication.authorization.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import basic.authentication.authorization.model.UserModel;
import basic.authentication.authorization.service.UserService;
import basic.authentication.authorization.util.Constants;

@Configuration
public class ApplicationConfiguration {

	@Autowired
	private UserService userService;

	@Bean(Constants.USER_PRICIPAL)
	@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public UserModel userModel() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		final String username = user.getUsername();
		UserModel userModel = userService.findUserModelByUsername(username);
		return userModel;
	}
}
