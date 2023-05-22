package com.date.api.practice;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Slf4j
public class ZonedDateTimePractice {

	/**
	 * java.time.ZonedDateTime practice
	 */
	@Test
	public void createZonedDateTime() {
		ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
		log.info("zonedDateTime1={}", zonedDateTime1);

		Clock clock1 = Clock.systemUTC();
		ZonedDateTime zonedDateTime2 = ZonedDateTime.now(clock1);
		log.info("zonedDateTime2: ", zonedDateTime2);

		ZonedDateTime zonedDateTime3 = ZonedDateTime.now(ZoneId.of("Asia/Calcutta"));
		log.info("zonedDateTime3={}", zonedDateTime3);
	}

	@Test
	public void convertZonedDateTimeToUtilDate() {
		Clock clock = Clock.systemDefaultZone();
		ZonedDateTime zonedDateTime = ZonedDateTime.now(clock);
		log.info("convertZonedDateTimeToUtilDate() zonedDateTime: {}", zonedDateTime);

		Date date = Date.from(zonedDateTime.toInstant());
		log.info("convertZonedDateTimeToUtilDate() date: {}", date);
	}

	@Test
	public void zonedDateTimeToOffsetDateTime() {
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		OffsetDateTime offsetDateTime1 = zonedDateTime.toOffsetDateTime();
		System.out.println(offsetDateTime1);
	}
}
