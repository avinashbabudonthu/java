package com.date.api.practice;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Slf4j
public class DurationPractice {

	@SneakyThrows
	@Test
	public void durationBetweenTwoDates() {
		// java.time.LocalDateTime
		LocalDateTime from = LocalDateTime.of(2018, Month.JULY, 20, 0, 0, 0);
		LocalDateTime to = LocalDateTime.of(2019, Month.JULY, 20, 23, 59, 59);
		final Duration duration = Duration.between(from, to);
		/*
		 * days=365, months=12, years=1, hours=8783, minutes=527039,
		 * milli-seconds=31622399000, nano-seconds=31622399000000000
		 */
		log.info("days={}, months={}, years={}, hours={}, minutes={}, milli-seconds={}, nano-seconds={}",
				duration.toDays(), (duration.toDays() / 30), ((duration.toDays() / 30) / 12), duration.toHours(),
				duration.toMinutes(), duration.toMillis(), duration.toNanos());

		// java.time.LocalDate
		LocalDate from2 = LocalDate.of(2021, Month.JUNE, 23);
		LocalDate to2 = LocalDate.of(2021, Month.JULY, 20);
		long days2 = ChronoUnit.DAYS.between(from2, to2);
		log.info("days2={}", days2); // days2=27
		long days3 = Duration.between(from2.atStartOfDay(), to2.atStartOfDay()).toDays();
		log.info("days3={}", days3); // days3=27

		// using java.util.Date
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		Date firstDate = sdf.parse("07/20/1987");
		Date secondDate = sdf.parse("07/20/2020");
		long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
		long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		long diffInYears = diffInDays / 365;
		/*
		 * diff-in-millis=1041465600000, diff-in-days=12054, diff-in-years=33
		 */
		log.info("diff-in-millis={}, diff-in-days={}, diff-in-years={}", diffInMillies, diffInDays, diffInYears);

		// using java.time.LocalDate
		LocalDate firstLocalDate = LocalDate.now();
		LocalDate secondLocalDate = firstLocalDate.minusDays(31);
		Period period = Period.between(secondLocalDate, firstLocalDate);
		int days = period.getDays();
		int months = period.getMonths();
		int years = period.getYears();
		/*
		 * days=0, months=1, years=0
		 */
		log.info("days={}, months={}, years={}", days, months, years);

		// using java.time.LocalDateTime
		LocalDateTime firstLocalDateTime = LocalDateTime.now();
		LocalDateTime secondLocalDateTime = firstLocalDateTime.minusMinutes(31);
		Duration duration2 = Duration.between(secondLocalDateTime, firstLocalDateTime);
		long durationMinutes = Math.abs(duration2.toMinutes());
		log.info("days={}", durationMinutes); // days=31

		// using java.time.temporal.ChronoUnit
		LocalDateTime dateTime1 = LocalDateTime.now();
		LocalDateTime dateTime2 = dateTime1.plusSeconds(50);
		long diff = ChronoUnit.SECONDS.between(dateTime1, dateTime2);
		log.info("diff={}", diff); // diff=50

		// using java.time.ZonedDateTime
		LocalDateTime ldt = LocalDateTime.now();
		ZonedDateTime now = ldt.atZone(ZoneId.of("America/Montreal"));
		ZonedDateTime sixMinutesBehind = now.withZoneSameInstant(ZoneId.of("Asia/Singapore")).minusMinutes(6);
		long diff2 = ChronoUnit.MINUTES.between(sixMinutesBehind, now);
		log.info("diff2={}", diff2); // diff2=6

		// java.time.temporal.Temporal until()
		LocalDateTime dateTime3 = LocalDateTime.now();
		LocalDateTime dateTime4 = dateTime3.plusSeconds(10);
		long diff3 = dateTime3.until(dateTime4, ChronoUnit.SECONDS);
		log.info("diff3={}", diff3); // diff3=10

	}

}
