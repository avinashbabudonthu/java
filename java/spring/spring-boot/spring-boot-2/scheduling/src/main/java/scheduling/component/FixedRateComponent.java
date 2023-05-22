package scheduling.component;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @Component
public class FixedRateComponent {

	@Scheduled(fixedRate = 1000)
	public void fixedRateScheduler() {
		log.info("Inside fixedRateScheduler(), time={}", new Date());
	}
}
