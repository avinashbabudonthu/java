package basic.authentication.authorization.util;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PasswordEncoder {

	@Test
	public void encode() {
		String hashedUserPassword = encode("user1");
		String hashedAdminPassword = encode("admin");

		log.info("hashedUserPassword: {}, hashedAdminPassword: {}", hashedUserPassword, hashedAdminPassword);
	}

	public String encode(String inputString) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(inputString);

	}
}
