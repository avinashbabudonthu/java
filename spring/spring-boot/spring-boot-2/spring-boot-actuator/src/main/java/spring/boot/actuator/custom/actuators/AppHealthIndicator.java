package spring.boot.actuator.custom.actuators;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class AppHealthIndicator implements HealthIndicator {

	@Autowired
	private HttpServletRequest httpServletRequest;

	@Override
	public Health health() {
		if (!isServiceRunning()) {
			return Health.down().withDetail("down", "App is down, restart").build();
		}
		return Health.up().withDetail("up", "App is up, all good").build();
	}

	private Boolean isServiceRunning() {
		// actual business logic here and return true/false
		if (null != httpServletRequest.getParameter("status") &&
				httpServletRequest.getParameter("status").equalsIgnoreCase("0"))
			return Boolean.FALSE;
		else
			return Boolean.TRUE;
	}
}
