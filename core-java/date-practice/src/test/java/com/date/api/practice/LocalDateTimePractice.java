package com.date.api.practice;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.*;
import java.util.Date;

@Slf4j
public class LocalDateTimePractice {

	/**
	 * java.time.LocalDateTime practice. This class useful to work on date or time or both
	 */
	@Test
	public void createLocalDateTime() {
		LocalDateTime localDateTime1 = LocalDateTime.now();
		log.info("localDateTime1: {}", localDateTime1);

		Clock clock1 = Clock.systemUTC();
		LocalDateTime localDateTime2 = LocalDateTime.now(clock1);
		log.info("localDateTime2: {}", localDateTime2);

		Clock clock2 = Clock.systemDefaultZone();
		LocalDateTime localDateTime3 = LocalDateTime.now(clock2);
		log.info("localDateTime3: {}", localDateTime3);
	}

	@Test
	public void convertLocalDateTimeToUtilDate() {
		Clock clock = Clock.systemDefaultZone();
		LocalDateTime localDateTime = LocalDateTime.now(clock);
		log.info("convertLocalDateTimeToUtilDate() localDateTime: {}", localDateTime);

		ZoneId zoneId = ZoneId.systemDefault();
		Date date = Date.from(localDateTime.atZone(zoneId).toInstant());
		log.info("convertLocalDateTimeToUtilDate() date: {}", date);
	}

	@Test
	public void convertLocalDateTimeToZonedDateTime() {
		Clock clock = Clock.systemDefaultZone();
		LocalDateTime localDateTime = LocalDateTime.now(clock);
		log.info("convertLocalDateTimeToZonedDateTime() localDateTime: {}", localDateTime);

		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
		log.info("convertLocalDateTimeToZonedDateTime() zonedDateTime: {}", zonedDateTime);
	}

	@Test
	public void convertLocalDateTimeToStringTimeStamp() {
		LocalDateTime localDateTime = LocalDateTime.now();
		Timestamp timestamp = Timestamp.valueOf(localDateTime);
		long time = timestamp.getTime();
		String timeStampAsString = String.valueOf(time);
		log.info("timeStampAsString: {}", timeStampAsString);
	}

	@Test
	public void localDateTimeToOffsetDateTime() {
		OffsetDateTime offsetDateTime = OffsetDateTime.of(LocalDateTime.of(2020, 6, 5, 7, 45),
				ZoneOffset.ofHoursMinutes(7, 45));
		log.info("offsetDateTime={}", offsetDateTime);

		// method 2
		LocalDateTime localDateTime = LocalDateTime.now();
		OffsetDateTime offsetDateTime2 = localDateTime.atOffset(ZoneOffset.ofHoursMinutes(5, 30));
		log.info("offsetDateTime2={}", offsetDateTime2);
	}

}