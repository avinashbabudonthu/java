package com.date.api.practice;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;

@Slf4j
public class ConversionFromClassToClass {

	@Test
	public void localDateToGregorianCalendar() {
		LocalDate localDate = LocalDate.now();
		GregorianCalendar gregorianCalendar = GregorianCalendar.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		log.info("date={}", gregorianCalendar.toString());
	}

	@SneakyThrows
	@Test
	public void localDateToXmlGregorianCalendar() {
		LocalDate localDate = LocalDate.now();
		GregorianCalendar gregorianCalendar = GregorianCalendar.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(gregorianCalendar);
		log.info("date={}", xmlGregorianCalendar.toString());
	}

	@Test
	public void utilDateToXmlGregorianCalendar() {
		Date date = new Date();
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		XMLGregorianCalendar xmlGregorianCalendar = null;
		try {
			xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		} catch (Exception e) {
			log.error("Exception while creating XMLGregorianCalendar", e);
		}

		log.info("XMLGregorianCalendar={}", xmlGregorianCalendar);
	}

	@Test
	public void xmlGregorianCalendarToUtilDate() {
		// create XMLGregorianCalendar
		Date date = new Date();
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		XMLGregorianCalendar xmlGregorianCalendar = null;
		try {
			xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		} catch (Exception e) {
			log.error("Exception while creating XMLGregorianCalendar", e);
		}

		// convert to util date
		Date resultUtilDate = xmlGregorianCalendar.toGregorianCalendar().getTime();

		log.info("result util-date={}", resultUtilDate);
	}

	@Test
	public void xmlGregorianCalendarToGregorianCalendar() {
		// create XMLGregorianCalendar
		Date date = new Date();
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		XMLGregorianCalendar xmlGregorianCalendar = null;
		try {
			xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		} catch (Exception e) {
			log.error("Exception while creating XMLGregorianCalendar", e);
		}

		GregorianCalendar resultGregorianCalendar = xmlGregorianCalendar.toGregorianCalendar();
		log.info("xmlGregorianCalendar={}", xmlGregorianCalendar);
		log.info("resultGregorianCalendar={}", resultGregorianCalendar);
	}

	@Test
	public void timeInMillisToGregorian() {
		Date date = new Date();
		long timeInMillis = date.getTime();
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTimeInMillis(timeInMillis);

		log.info("timeInMillis={}", timeInMillis);
		log.info("gregorianCalendar={}", gregorianCalendar);
	}

}