package com.java.math;

import java.math.BigDecimal;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BigDecimalPractice {

	/**
	 * Create BigDecimal object
	 */
	@Test
	public void create() {
		BigDecimal value1 = new BigDecimal("-123456");
		BigDecimal value2 = new BigDecimal("78912");

		log.info("value1={}", value1); // value1=-123456
		log.info("value2={}", value2); // value2=78912
	}

	/**
	 * Get int value from BigDecimal object
	 */
	@Test
	public void intValue() {
		BigDecimal value1 = new BigDecimal("-123456");
		BigDecimal value2 = new BigDecimal("78912");

		int intValue1 = value1.intValue();
		int intValue2Exact = value2.intValueExact();

		log.info("intValue1={}", intValue1); // intValue1=-123456
		log.info("intValue2Exact={}", intValue2Exact); // intValue2Exact=78912
	}

	/**
	 * Find min of 2 BigDecimal values
	 */
	@Test
	public void min() {
		BigDecimal value1 = new BigDecimal("-123456");
		BigDecimal value2 = new BigDecimal("78912");

		BigDecimal result1 = value1.min(value2);
		BigDecimal result2 = value2.min(value1);

		log.info("result1={}, result2={}", result1, result2); // result1=-123456, result2=-123456
	}

	@Test
	public void max() {
		BigDecimal value1 = new BigDecimal("-123456");
		BigDecimal value2 = new BigDecimal("78912");

		BigDecimal result1 = value1.max(value2);
		BigDecimal result2 = value2.max(value1);

		log.info("result1={}, result2={}", result1, result2); // result1=-123456, result2=-123456
	}

	/**
	 * Converts this BigDecimal to a byte, checkingfor lost information. 
	 * If this BigDecimal has anonzero fractional part or is out of the possible range for a byte result 
	 * then an ArithmeticException isthrown
	 */
	@Test
	public void byteValueExtract() {
		BigDecimal value2 = new BigDecimal("123");

		byte value2Byte = value2.byteValueExact();

		log.info("value2Byte={}", value2Byte);
	}

}