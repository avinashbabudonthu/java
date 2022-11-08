package com.date.api.practice;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Slf4j
public class InstantPractice {

	@Test
	public void createInstant() {
		Instant instant = Instant.now();
		log.info("instant={}", instant); //instant=2021-06-17T03:10:30.169Z
	}

	@Test
	public void instantToOffsetDateTime() {
		Instant instant = Instant.now();
		OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(7));
		log.info("offsetDateTime={}", offsetDateTime); // offsetDateTime=2021-06-17T10:10:44.697+07:00
	}

	@Test
	public void instantToUtilDate() {
		Instant instant = Instant.now();
		log.info("instant={}", instant); // instant=2021-06-17T03:10:01.710Z

		Date date = Date.from(instant);
		log.info("date={}", date); // date=Thu Jun 17 08:40:01 IST 2021
	}

}
