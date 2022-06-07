package spring.boot.actuator.component;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class InfoContributorComponent implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		Map<String, Object> infoMap = new HashMap<>();
		infoMap.put("environment", "dev");

		builder.withDetail("build", "1.0");
		builder.withDetails(infoMap);
	}

}
