package com.java.strings;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringFormatPractice {

	@Test
	public void stringFormatConventionsAndFlags() {
		String str1 = String.format("Welcome to number %d, %d, %d and %d", 1, 2, 3, 4);
		log.info("str1={}", str1); // str1=Welcome to number 1, 2, 3 and 4

		String str2 = String.format("Decimal value with 2 decimals: %.2f", 1.2356);
		log.info("str2={}", str2); // str2=Decimal value with 2 decimals: 1.24

		String str3 = String.format("%d, %o, %x, %X", 32, 32, 32, 32);
		log.info("str3={}", str3); // str3=32, 40, 20, 20

		String str4 = String.format("%d, %#o, %#x, %#X", 32, 32, 32, 32);
		log.info("str4={}", str4); // str4=32, 040, 0x20, 0X20

		log.info("-- right justify -- ");
		String str5 = String.format("num1:%4d, num2:%4d ", 6, 287);
		String str6 = String.format("num1:%4d, num2:%4d ", 657, 7);
		String str7 = String.format("num1:%04d, num2:%04d ", 877, 6);
		log.info("str5={}", str5); // str5=num1:   6, num2: 287
		log.info("str6={}", str6); // str6=num1: 657, num2:   7
		log.info("str7={}", str7); // str7=num1:0877, num2:0006

		log.info("-- left justify -- ");
		String str8 = String.format("num1:%-4d, num2:%-4d ", 6, 287);
		String str9 = String.format("num1:%-4d, num2:%-4d ", 657, 7);
		log.info("str8={}", str8); // str8=num1:6   , num2:287
		log.info("str9={}", str9); // str9=num1:657 , num2:7

		log.info("-- group separator");
		String str10 = String.format("%d", 1234567);
		String str11 = String.format("%,d", 1234567);
		String str12 = String.format("%,.2f", 123457.6);
		log.info("str10={}", str10); // str10=1234567
		log.info("str11={}", str11); // str11=1,234,567
		log.info("str12={}", str12); // str12=123,457.60

		String s13 = String.format("%d", 123);
		String s14 = String.format("%d", -123);
		String s15 = String.format("% d", 123);
		String s16 = String.format("% d", -123);
		String s17 = String.format("%+d", 123);
		String s18 = String.format("%+d", -123);
		String s19 = String.format("%(d", 123);
		String s20 = String.format("%(d", -123);
		String s21 = String.format("% (d", 123);
		log.info("s13={}", s13); // s13=123
		log.info("s14={}", s14); // s14=-123
		log.info("s15={}", s15); // s15= 123
		log.info("s16={}", s16); // s16=-123
		log.info("s17={}", s17); // s17=+123
		log.info("s18={}", s18); // s18=-123
		log.info("s19={}", s19); // s19=123
		log.info("s20={}", s20); // s20=(123)
		log.info("s21={}", s21); // s21= 123
	}

	@Test
	public void stringFormat() {
		String str = "Welcome to %s. Visit %s (URL - %s) for more details.";
		String finalString = String.format(str, "Java world", "Cerebro", "https://cerebroap.herokuapp.com/");

		// finalString: Welcome to Java world. Visit Cerebro (URL - https://cerebroap.herokuapp.com/) for more details.
		System.out.println("finalString: " + finalString);
	}
	
	/**
	     * To use (%) percentage symbol in String.format we have to use %%(double percentage) as escape character
	     *
	     * Input:
	     * Ana got %s% percentage
	     * Output:
	     * java.util.UnknownFormatConversionException
	     *
	     * Input:
	     * Ana got %s%% percentage
	     * Output:
	     * Ana got 90% percentage
	     *
	     */
	    @Test
	    public void format2(){
		String str2 = "Ana got %s%% percentage";
		String result = String.format(str2, "90");
		System.out.println(result);
	    }
}
