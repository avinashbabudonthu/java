package com.date.api.practice;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

@SuppressWarnings("all")
@Slf4j
public class UtilDate {

	/**
	 * Convert String to java.util.Date
	 * 
	 * String to Date -> SimpleDateFormat.parse(String)
	 * Date to String -> SimpleDateFormat.format(date)
	 * @throws ParseException 
	 */
	@SneakyThrows
	@Test
	public void convertStringToDate() {
		// 20-Jul-2017
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MMM-yyyy");
		String date1 = "20-Jul-2017";

		Date convertedDate1 = simpleDateFormat1.parse(date1);
		log.info("convertedDate1: {}", convertedDate1);
		log.info("simpleDateFormat1.format(convertedDate1): {}", simpleDateFormat1.format(convertedDate1));

		// 20/07/2017
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
		String date2 = "20/07/2017";
		Date convertedDate2 = simpleDateFormat2.parse(date2);
		log.info("convertedDate2: {}", convertedDate2);
		log.info("simpleDateFormat2.format(convertedDate2): {}", simpleDateFormat2.format(convertedDate2));

		//Thu, July 20 2017
		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("E, MMM dd yyyy");
		String date3 = "Thu, July 20 2017";
		Date convertedDate3 = simpleDateFormat3.parse(date3);
		log.info("convertedDate3: {}", convertedDate3);
		log.info("simpleDateFormat3.format(convertedDate3): {}", simpleDateFormat3.format(convertedDate3));

		//Thursday, July 10 2017 12:10:08 PM
		SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("EEEE, MMM dd yyyy HH:mm:ss a");
		String date4 = "Thursday, July 20 2017 12:10:08 PM";
		Date convertedDate4 = simpleDateFormat4.parse(date4);
		log.info("convertedDate4: {}", convertedDate4);
		log.info("simpleDateFormat4.format(convertedDate4): {}", simpleDateFormat4.format(convertedDate4));
	}

	@Test
	public void convertDateToString() {
		Date date = new Date();
		SimpleDateFormat targetSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String targetDateString = targetSimpleDateFormat.format(date);
		log.info(targetDateString);
	}

	@Test
	public void convertDateToLocalDateTime() {
		final Date date = new Date();
		log.info("date={}", date);
		Instant instant = date.toInstant();
		log.info("convertUtilDateToLocalDateTime() instant: {}", instant);

		// method 1
		ZoneId systemDefaultZoneId = ZoneId.systemDefault();
		LocalDateTime localDateTime = date.toInstant().atZone(systemDefaultZoneId).toLocalDateTime();
		log.info("localDateTime={}", localDateTime);

		// method 2
		LocalDateTime localDateTime2 = LocalDateTime.ofInstant(instant, systemDefaultZoneId);
		log.info("localDateTime2: {}", localDateTime2);
	}

	@Test
	public void convertUtilDateToLocalDate() {
		Date date = new Date();
		log.info("convertUtilDateToLocalDate() date: {}", date);

		Instant instant = date.toInstant();
		log.info("convertUtilDateToLocalDate() instant: {}", instant);

		ZoneId systemDefaultZoneId = ZoneId.systemDefault();
		LocalDate localDate = instant.atZone(systemDefaultZoneId).toLocalDate();
		log.info("convertUtilDateToLocalDate() localDate: {}", localDate);
	}

	@Test
	public void convertUtilDateToLocalTime() {
		Date date = new Date();
		log.info("convertUtilDateToLocalTime() date: {}", date);

		Instant instant = date.toInstant();
		log.info("convertUtilDateToLocalTime() instant: {}", instant);

		ZoneId systemDefaultZoneId = ZoneId.systemDefault();
		LocalTime localTime = instant.atZone(systemDefaultZoneId).toLocalTime();
		log.info("convertUtilDateToLocalTime() localTime: {}", localTime);
	}

	@Test
	public void convertUtilDateToZonedDateTime() {
		Date date = new Date();
		log.info("date: {}", date);

		// method 1
		Instant instant = date.toInstant();
		log.info("instant: {}", instant);

		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = instant.atZone(zoneId);
		log.info("zonedDateTime: {}", zonedDateTime);

		// method 2
		ZonedDateTime zonedDateTime2 = ZonedDateTime.ofInstant(instant, zoneId);
		log.info("zonedDateTime2: {}", zonedDateTime2);
	}

	@Test
	public void before() {
		Date date1 = new Date(2020, 4, 3);
		Date date2 = new Date(2020, 4, 2);

		Boolean isDate1BeforeDate2 = date1.before(date2);
		log.info("date1={}, date2={}, before={}", date1, date2, isDate1BeforeDate2);
	}

	@Test
	public void after() {
		Date date1 = new Date(2020, 4, 3);
		Date date2 = new Date(2020, 4, 2);

		Boolean isDate1AfterDate2 = date1.after(date2);
		log.info("date1={}, date2={}, after={}", date1, date2, isDate1AfterDate2);
	}

	@Test
	public void utilDateToTimeStamp() {
		Date date1 = new Date();
		Long timestamp = date1.getTime();
		log.info("time-stamp={}", timestamp);
	}

	@Test
	public void timeStampToUtilDate() {
		Date date1 = new Date(1598443483219L);
		log.info("date1={}", date1);
	}

}
