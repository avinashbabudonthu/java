package com.internationalization;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

@Slf4j
public class DecimalFormatPractice {

	@Test
	public void createDecimalFormatObject() {
		String pattern = "###,###.###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		log.info("{}", decimalFormat);
	}

	@Test
	public void applyNewPatterns() {
		String pattern1 = "###,###.###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern1);
		decimalFormat.applyPattern("#0.##");
		log.info("{}", decimalFormat);
	}

	@Test
	public void formatNumber() {
		String pattern = "###,###.###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		String formattedNumber = decimalFormat.format(123456789.123);
		log.info("{}", formattedNumber); // 123,456,789.123
	}

	@Test
	public void formatNumberSpecificToLocale() {
		String pattern = "###,###.###";

		// US Locale
		DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("en", "US"));
		decimalFormat.applyPattern(pattern);
		String formatNumber = decimalFormat.format(123456789.123);
		log.info("{}", formatNumber); // 123,456,789.123

		// Denmark Locale
		DecimalFormat denmarkDecimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("da", "DK"));
		denmarkDecimalFormat.applyPattern(pattern);
		String formatNumber2 = denmarkDecimalFormat.format(123456789.123);
		log.info("{}", formatNumber2); // 123.456.789,123
	}

	/**
	 * Method to set custom separators for number
	 * 
	 * Other methods in DecimalFormatSymbols:
	 * 	setDecimalSeparator();
		setGroupingSeparator();
		setCurrency();
		setCurrencySymbol();
		setDecimalSeparator();
		setDigit();
		setExponentSeparator();
		setGroupingSeparator();
		setInfinity();
		setInternationalCurrencySymbol();
		setMinusSign();
		setMonetaryDecimalSeparator();
		setNaN();
		setPatternSeparator();
		setPercent();
		setPerMill();
		setZeroDigit();
	 */
	@Test
	public void customDecimalFormats() {
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(new Locale("en", "US"));
		decimalFormatSymbols.setDecimalSeparator(';');
		decimalFormatSymbols.setGroupingSeparator(':');

		String pattern = "#,##0.###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, decimalFormatSymbols);
		String number = decimalFormat.format(123456789.123);
		log.info("{}", number); // 123:456:789;123
	}

	@Test
	public void groupingDigits() {
		String pattern1 = "#,###.###";
		DecimalFormat decimalFormat1 = new DecimalFormat(pattern1);
		decimalFormat1.setGroupingSize(4);
		String number = decimalFormat1.format(123456789.123);
		log.info("{}", number); // 1,2345,6789.123

		String pattern2 = "####,####.###";
		DecimalFormat decimalFormat2 = new DecimalFormat(pattern2);
		String number2 = decimalFormat2.format(123456789.123);
		log.info("{}", number2); // 1,2345,6789.123

		String pattern3 = "####,####.###";
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(';');
		decimalFormatSymbols.setGroupingSeparator(':');
		DecimalFormat decimalFormat3 = new DecimalFormat(pattern3, decimalFormatSymbols);
		String number3 = decimalFormat3.format(123456789.123);
		log.info("{}", number3); // 1:2345:6789;123
	}
}