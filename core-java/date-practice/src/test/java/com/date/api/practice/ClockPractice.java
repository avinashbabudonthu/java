package com.date.api.practice;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.Clock;

@Slf4j
public class ClockPractice {

	@Test
	public void createClock() {
		Clock clock = Clock.systemUTC();
		log.info("instant={}, millis={}", clock.instant(), clock.millis());

		Clock clock2 = Clock.systemDefaultZone();
		log.info("instant={}, millis={}", clock2.instant(), clock2.millis());
	}

	/**
	 * java.time.Clock practice
	 */
	@Test
	public void clockMethods() {
		Clock clock = Clock.systemUTC();
		log.info("clock.instant(): {}", clock.instant());
		log.info("clock.millis(): {}", clock.millis());
		log.info("clock.getZone(): {}", clock.getZone());
	}
}
