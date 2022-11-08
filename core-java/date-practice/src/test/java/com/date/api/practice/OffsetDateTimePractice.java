package com.date.api.practice;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
public class OffsetDateTimePractice {

	@Test
	public void create() {
		OffsetDateTime offsetDateTime1 = OffsetDateTime.now();
		log.info("offsetDateTime1={}", offsetDateTime1);

		OffsetDateTime offsetDateTime2 = OffsetDateTime.now(Clock.systemDefaultZone());
		log.info("offsetDateTime2={}", offsetDateTime2);

		OffsetDateTime offsetDateTime3 = OffsetDateTime.now(ZoneId.systemDefault());
		log.info("offsetDateTime3={}", offsetDateTime3);
	}

	@Test
	public void offsetDateTimeToLocalDateTime() {
		OffsetDateTime offsetDateTime1 = OffsetDateTime.now();
		log.info("offsetDateTime1={}", offsetDateTime1);

		LocalDateTime localDateTime = offsetDateTime1.toLocalDateTime();
		log.info("localDateTime={}", localDateTime);
	}

	@Test
	public void offsetDateTimeToLocalDate() {
		OffsetDateTime offsetDateTime1 = OffsetDateTime.now();
		log.info("offsetDateTime1={}", offsetDateTime1);

		LocalDate localDate = offsetDateTime1.toLocalDate();
		log.info("localDate={}", localDate);
	}

	@Test
	public void offsetDateTimeToLocalTime() {
		OffsetDateTime offsetDateTime1 = OffsetDateTime.now();
		log.info("offsetDateTime1={}", offsetDateTime1);

		LocalTime localDate = offsetDateTime1.toLocalTime();
		log.info("localDate={}", localDate);
	}

	@Test
	public void offsetDateTimeToZonedDateTime() {
		OffsetDateTime offsetDateTime1 = OffsetDateTime.now();
		log.info("offsetDateTime1={}", offsetDateTime1);

		ZonedDateTime zonedDateTime = offsetDateTime1.toZonedDateTime();
		log.info("localDate={}", zonedDateTime);
	}

	@Test
	public void offsetDateTimeToInstant() {
		OffsetDateTime offsetDateTime1 = OffsetDateTime.now();
		log.info("offsetDateTime1={}", offsetDateTime1);

		Instant instant = offsetDateTime1.toInstant();
		log.info("localDate={}", instant);
	}

	@Test
	public void offsetDateTimeToOffsetTime() {
		OffsetDateTime offsetDateTime1 = OffsetDateTime.now();
		log.info("offsetDateTime1={}", offsetDateTime1);

		OffsetTime offsetTime = offsetDateTime1.toOffsetTime();
		log.info("localDate={}", offsetTime);
	}

	@Test
	public void offsetDateTimeYearMonthDay() {
		OffsetDateTime offsetDateTime1 = OffsetDateTime.now();
		log.info("offsetDateTime1={}", offsetDateTime1);

		int year = offsetDateTime1.getYear();
		Month month = offsetDateTime1.getMonth();
		int monthNumber = month.getValue();
		int dayOfMonth = offsetDateTime1.getDayOfMonth();
		DayOfWeek dayOfWeek = offsetDateTime1.getDayOfWeek();
		int dayOfYear = offsetDateTime1.getDayOfYear();
		ZoneOffset zoneOffset = offsetDateTime1.getOffset();

		log.info("year={}, month={}, monthNumber={}, dayOfMonth={}, dayOfWeek={}, dayOfYear={}, zoneOffSet={}", year,
				month, monthNumber, dayOfMonth, dayOfWeek, dayOfYear, zoneOffset);
	}

	@Test
	public void offsetDateTimeHourMinuteSecond() {
		OffsetDateTime offsetDateTime1 = OffsetDateTime.now();
		log.info("offsetDateTime1={}", offsetDateTime1);

		int hour = offsetDateTime1.getHour();
		int minute = offsetDateTime1.getMinute();
		int second = offsetDateTime1.getSecond();
		int nano = offsetDateTime1.getNano();

		log.info("hour={}, minute={}, second={}, nano={}", hour, minute, second, nano);
	}

	@Test
	public void addYearMonthEtc() {
		OffsetDateTime offsetDateTime = OffsetDateTime.now();
		log.info("offsetDateTime1={}", offsetDateTime);

		log.info("plus-1-day={}", offsetDateTime.plusDays(1));
		log.info("plus-1-month={}", offsetDateTime.plusMonths(1));
		log.info("plus-1-year={}", offsetDateTime.plusYears(1));
		log.info("plus-1-hour={}", offsetDateTime.plusHours(1));
		log.info("plus-10-minutes={}", offsetDateTime.plusMinutes(10));
		log.info("plus-10-seconds={}", offsetDateTime.plusSeconds(10));
	}

	@Test
	public void subtractYearMonthEtc() {
		OffsetDateTime offsetDateTime = OffsetDateTime.now();
		log.info("offsetDateTime1={}", offsetDateTime);

		log.info("plus-1-day={}", offsetDateTime.minusDays(1));
		log.info("plus-1-month={}", offsetDateTime.minusMonths(1));
		log.info("plus-1-year={}", offsetDateTime.minusYears(1));
		log.info("plus-1-hour={}", offsetDateTime.minusHours(1));
		log.info("plus-10-minutes={}", offsetDateTime.minusMinutes(10));
		log.info("plus-10-seconds={}", offsetDateTime.minusSeconds(10));
	}

	@Test
	public void compare() {
		LocalDateTime localDateTime = LocalDateTime.now();

		OffsetDateTime offsetDateTime1 = OffsetDateTime.of(localDateTime, ZoneOffset.ofHoursMinutes(5, 30));

		OffsetDateTime offsetDateTime2 = OffsetDateTime.of(localDateTime, ZoneOffset.ofHoursMinutes(5, 30));

		OffsetDateTime offsetDateTime3 = OffsetDateTime.of(localDateTime, ZoneOffset.ofHoursMinutes(6, 30));

		// Using isEqual()
		if (offsetDateTime1.isEqual(offsetDateTime2)) {
			System.out.println("offsetDateTime1 and offsetDateTime2 are equal.");
		} else {
			System.out.println("offsetDateTime1 and offsetDateTime2 are not equal.");
		}

		// Using compareTo()
		if (offsetDateTime1.compareTo(offsetDateTime2) == 0) {
			System.out.println("offsetDateTime1 and offsetDateTime2 are equal.");
		} else {
			System.out.println("offsetDateTime1 and offsetDateTime2 are not equal.");
		}

		// Using isAfter()
		if (offsetDateTime1.isAfter(offsetDateTime3)) {
			System.out.println("offsetDateTime1 is after offsetDateTime3");
		}

		// Using isBefore()
		if (offsetDateTime3.isBefore(offsetDateTime2)) {
			System.out.println("offsetDateTime3 is before offsetDateTime2");
		}
	}

	@Test
	public void stringToOffsetDateTime() {
		// Parsing ISO offset date time
		OffsetDateTime dateTime = OffsetDateTime.parse("2017-07-07T21:36:10.598+05:30",
				DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		System.out.println(dateTime);

		// Parsing 'yyyy-MMM-dd HH:mm:ss Z' pattern
		OffsetDateTime dateTime1 = OffsetDateTime.parse("2017-May-02 23:35:05 +0530",
				DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss Z"));
		System.out.println(dateTime1);

		// Parsing 'yyyy-MM-dd KK:mm:ss a x' pattern
		OffsetDateTime dateTime2 = OffsetDateTime.parse("2017-05-30 10:20:30 AM +0530",
				DateTimeFormatter.ofPattern("yyyy-MM-dd KK:mm:ss a x"));
		System.out.println(dateTime2);

		// Formatting 'cccc, MMMM dd, yyyy KK:mm a X' pattern
		OffsetDateTime dateTime3 = OffsetDateTime.parse("Wednesday, May 31, 2017 10:21 PM +0530",
				DateTimeFormatter.ofPattern("cccc, MMMM dd, yyyy KK:mm a X"));
		System.out.println(dateTime3);
	}

	@Test
	public void offsetDateTimeToString() {
		OffsetDateTime dateTime = OffsetDateTime.now();

		// Formatting ISO offset date time
		System.out.println(dateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));

		// Formatting 'yyyy-MMM-dd HH:mm:ss Z' pattern
		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss Z")));

		// Formatting 'yyyy-MM-dd KK:mm:ss a x' pattern
		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd KK:mm:ss a x")));

		// Formatting 'cccc, MMMM dd, yyyy KK:mm a X' pattern
		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("cccc, MMMM dd, yyyy KK:mm a X")));
	}

	@SneakyThrows
	@Test
	public void convertUtilDateToOffsetDateTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
		String date = "Wed May 20 17:46:34 UTC 2020";
		Date convertedDate = simpleDateFormat.parse(date);
		OffsetDateTime offsetDateTime = convertedDate.toInstant().atOffset(ZoneOffset.UTC);
		log.info("convertedDate={}, offsetDateTime={}", convertedDate, offsetDateTime);
	}

}