package scheduling.component;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;
import scheduling.util.Constants;

@Slf4j
//@Component
public class CronComponent {

	@Scheduled(cron = Constants.TWO_MINUTES_CRON)
	public void twoMinutesScheduler() {
		log.info("inside twoMinutesScheduler={}", new Date());
	}
}
