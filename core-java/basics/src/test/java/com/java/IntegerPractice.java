package com.java;

import org.junit.Test;

public class IntegerPractice {

	/**
	 * int -> Integer
	 * auto boxing can do this but valueOf will cache the value for better space & time performance
	  */
	@Test
	public void valueOf() {
		int i = 10;
		Integer j = Integer.valueOf(i);
		System.out.println(j);
	}

	/**
	 * String to signed int
	 */
	@Test
	public void parseInt() {
		int i1 = Integer.parseInt("100");
		System.out.println(i1);
		int i2 = Integer.parseInt("-101");
		System.out.println(i2);
	}

	/**
	 * String to unsigned int
	 */
	@Test
	public void parseUnsignedInt() {
		int i1 = Integer.parseUnsignedInt("100");
		System.out.println(i1); // 100
		int i2 = Integer.parseUnsignedInt("-101"); // java.lang.NumberFormatException: Illegal leading minus sign on unsigned string -101.
	}

}
