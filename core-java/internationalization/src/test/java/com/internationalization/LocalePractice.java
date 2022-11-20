package com.internationalization;

import org.junit.Test;

import java.util.Locale;

/**
 * Internationalization (I18N) practice example
 * @author Avinash Babu Donthu
 *
 */
public class LocalePractice {

	@Test
	public void localObjectByCountry() {
		Locale canadaLocale = Locale.CANADA;
		System.out.println("canadaLocale: " + canadaLocale + ", Language: " + canadaLocale.getLanguage() + ", country: "
				+ canadaLocale.getCountry());

		Locale canadaFrenchLocale = Locale.CANADA_FRENCH;
		System.out.println("canadaFrenchLocale: " + canadaFrenchLocale); // fr_CA

		Locale chineseLocale = Locale.CHINESE;
		System.out.println("chineseLocale: " + chineseLocale); // chineseLocale: zh

		Locale chinaLocale = Locale.CHINA;
		System.out.println("chinaLocale: " + chinaLocale); // chinaLocale: zh_CN
	}

	@Test
	public void createLocalObject() {
		Locale englishLocale = new Locale("en");
		System.out.println("englishLocale: " + englishLocale); // englishLocale: en

		Locale usLocale = new Locale("en", "US");
		System.out.println("usLocale: " + usLocale.toString()); // usLocale: en_US

		Locale ukEnglishLocale = new Locale("en", "UK");
		System.out.println("ukEnglishLocale: " + ukEnglishLocale); // ukEnglishLocale: en_UK

		Locale canadaEnglishLocale = new Locale("en", "CA");
		System.out.println("canadaEnglishLocale: " + canadaEnglishLocale); // canadaEnglishLocale: en_CA

		// using Locale.Builder
		Locale usEnglishLocale2 = new Locale.Builder().setLanguage("en").setRegion("US").build();
		System.out.println("usEnglishLocale2: " + usEnglishLocale2); // usEnglishLocale2: en_US

		// using forLanguageTag() method
		Locale usEnglishLocale3 = Locale.forLanguageTag("en-US");
		System.out.println("usEnglishLocale3: " + usEnglishLocale3); // usEnglishLocale3: en_US
	}

	@Test
	public void localObjectLanguageWise() {
		Locale enUS = new Locale("en", "US");
		System.out.println(enUS.toString());

		Locale enCA = new Locale("en", "CA");
		System.out.println(enCA.toString());

		Locale esUS = new Locale("es", "US");
		System.out.println(esUS.toString());

		Locale frCA = new Locale("fr", "CA");
		System.out.println(frCA.toString());
	}

}