package scheduling.component;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @Component
public class FixedDelayComponent {

	@Scheduled(fixedDelay = 2000, initialDelay = 2000)
	public void fixedDelayScheduler() {
		log.info("Inside fixedDelayScheduler(), time={}", new Date());
	}

}
