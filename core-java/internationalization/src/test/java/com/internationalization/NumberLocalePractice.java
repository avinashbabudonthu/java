package com.internationalization;

import org.junit.Test;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

public class NumberLocalePractice {

	@Test
	public void createNumberFormatObject() {
		Locale denmarkLocale = new Locale("da", "DK");
		NumberFormat numberFormat = NumberFormat.getInstance(denmarkLocale);
		System.out.println(numberFormat);
	}

	/**
	 * In Denmark decimals will be separated by ,(comma)
	 */
	@Test
	public void formatNumber() {
		Locale denmarkLocale = new Locale("da", "DK");
		NumberFormat numberFormat = NumberFormat.getInstance(denmarkLocale);
		String number = numberFormat.format(133.45);
		System.out.println(number); // 133,45
	}

	@Test
	public void formatCurrency() {
		// Denmark currency
		Locale denmarkLocale = new Locale("da", "DK");
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(denmarkLocale);
		String currency = currencyFormat.format(1544.15);
		System.out.println(currency); // kr 1.544,15

		// US currency
		Locale usLocale = new Locale("en", "US");
		NumberFormat currencyFormat2 = NumberFormat.getCurrencyInstance(usLocale);
		String currency2 = currencyFormat2.format(1245.26);
		System.out.println(currency2);// $1,245.26

		// India currency
		Locale indiaLocale = new Locale("en", "US");
		NumberFormat currencyFormat3 = NumberFormat.getCurrencyInstance(indiaLocale);
		currencyFormat3.setCurrency(Currency.getInstance("INR"));
		String currency3 = currencyFormat3.format(1245.26);
		System.out.println(currency3); // INR1,245.26
	}

	@Test
	public void formatPercentage() {
		Locale usLocale = new Locale("en", "US");
		NumberFormat percentageFormat = NumberFormat.getPercentInstance(usLocale);
		String percentage = percentageFormat.format(99.56);
		System.out.println(percentage);
	}

	@Test
	public void minMaxNoOfDigits() {
		Locale usLocale = new Locale("en", "US");
		NumberFormat numberFormat = NumberFormat.getInstance(usLocale);
		// set min and max number of digits before decimal
		numberFormat.setMinimumIntegerDigits(2);
		numberFormat.setMaximumIntegerDigits(9);

		// set min and max number of digits after decimal
		numberFormat.setMinimumFractionDigits(2);
		numberFormat.setMaximumFractionDigits(6);

		String number = numberFormat.format(1.2);
		System.out.println(number); // 01.20
	}

	@Test
	public void roundingNumbers() {
		Locale usLocale = new Locale("en", "US");
		NumberFormat numberFormat = NumberFormat.getInstance(usLocale);
		numberFormat.setRoundingMode(RoundingMode.HALF_DOWN);
		numberFormat.setMinimumFractionDigits(0);
		numberFormat.setMaximumFractionDigits(0);

		String number = numberFormat.format(123.5);
		System.out.println(number); // 123
	}

	@Test
	public void parseNumber() throws ParseException {
		Locale usLocale = new Locale("en", "US");
		NumberFormat numberFormat = NumberFormat.getInstance(usLocale);
		Number number = numberFormat.parse("125.12");
		System.out.println(number); // 125.12
	}

}