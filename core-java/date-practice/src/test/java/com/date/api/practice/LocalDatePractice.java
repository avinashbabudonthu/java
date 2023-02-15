package com.date.api.practice;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

@Slf4j
public class LocalDatePractice {

	@Test
	public void createLocalDateWithCurrentDate() {
		LocalDate localDate = LocalDate.now();
		log.info("local-date={}", localDate);
	}

	/**
	 * java.time.LocalDate practice. This class will have only date part without time part
	 */
	@Test
	public void createLocalDate() {
		LocalDate localDate1 = LocalDate.now();
		log.info("localDate: {}", localDate1);

		Clock clock1 = Clock.systemUTC();
		LocalDate localDate2 = LocalDate.now(clock1);
		log.info("localDate2={}", localDate2);
	}

	/**
	 * Add 1 day, 1 week, 1 month to date
	 */
	@Test
	public void addDayWeekMonth() {
		LocalDate localDate = LocalDate.now();
		log.info("localDate: {}", localDate);

		// add 1 day
		LocalDate tomorrow = localDate.plus(1, ChronoUnit.DAYS);
		log.info("tomorrow: {}", tomorrow);

		// add 1 week
		LocalDate nextWeek = localDate.plus(1, ChronoUnit.WEEKS);
		log.info("nextWeek: {}", nextWeek);

		// add 1 month
		LocalDate nextMonth = localDate.plus(1, ChronoUnit.MONTHS);
		log.info("nextMonth: {}", nextMonth);

		// add 1 year
		LocalDate nextYear = localDate.plus(1, ChronoUnit.YEARS);
		log.info("nextYear: {}", nextYear);

		// add 10 years
		LocalDate nextDecade = localDate.plus(1, ChronoUnit.DECADES);
		log.info("nextDecade: {}", nextDecade);
	}

	/**
	 * Get next Sunday
	 */
	@Test
	public void nextSunday() {
		LocalDate today = LocalDate.now();
		LocalDate nextSunday = today.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		log.info("next sunday: {}", nextSunday);
	}

	/**
	 * Get second Saturday of next month
	 */
	@Test
	public void nextMonthSecondSaturday() {
		LocalDate today = LocalDate.now();
		LocalDate nextMonthSecondSaturday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY))
				.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		log.info("Next month second saturday: {}", nextMonthSecondSaturday);
	}

	@Test
	public void convertLocalDateToUtilDate() {
		LocalDate localDate = LocalDate.now();
		log.info("convertLocalDateToUtilDate() localDate: {}", localDate);

		ZoneId zoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(zoneId).toInstant());
		log.info("convertLocalDateToUtilDate() date: {}", date);
	}

	/**
	 * Convert String to java.time.LocalDate
	 */
	@Test
	public void convertStringToLocalDate() {
		// 20/07/2017
		String date1 = "20/07/2017";
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate localDate1 = LocalDate.parse(date1, formatter1);
		log.info("localDate1: {}", localDate1);
		log.info("formatter1.format(localDate1): {}", formatter1.format(localDate1));

		//20-07-2017
		String date2 = "2017-07-21";
		LocalDate localDate2 = LocalDate.parse(date2);
		log.info("localDate2: {}", localDate2);

		// 20-Jul-2017
		String date3 = "20-Jul-2017";
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d-MMM-yyyy");
		LocalDate localDate3 = LocalDate.parse(date3, formatter2);
		log.info("localDate3: {}", localDate3);
		log.info("formatter2.format(localDate3): {}", formatter2.format(localDate3));

		//Thu, Jul 20 2017
		String date4 = "Thu, Jul 20 2017";
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("E, MMM d yyyy");
		LocalDate localDate4 = LocalDate.parse(date4, formatter3);
		log.info("localDate4: {}", localDate4);
		log.info("formatter3.format(localDate4): {}", formatter3.format(localDate4));

		//Thursday, Jul 10 2017 12:10:08 PM
		String date5 = "Thursday, Jul 20 2017 12:10:08 PM";
		DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("EEEE, MMM d yyyy HH:mm:ss a");
		LocalDateTime localDate5 = LocalDateTime.parse(date5, formatter4);
		log.info("localDate5: {}", localDate5);
		log.info("formatter4.format(localDate5): {}", formatter4.format(localDate5));
	}

	@Test
	public void convertLocalDateToString(){
		LocalDate localDate = LocalDate.now();
		log.info("localDate={}", localDate); // localDate=2023-02-15

		// To yyyyMMdd
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String date1 = localDate.format(dateTimeFormatter);
		log.info("date1={}", date1); // date1=20230215

		// To MMyyyydd
		DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("MMyyyydd");
		String date2 = localDate.format(dateTimeFormatter2);
		log.info("date2={}", date2); // date2=02202315
	}

}