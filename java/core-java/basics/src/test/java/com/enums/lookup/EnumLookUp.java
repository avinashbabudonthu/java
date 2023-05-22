package com.enums.lookup;

import org.junit.Test;

/**
 * Steps:
 * Create an enum
 * Create static HashMap
 * Initialize HashMap using static block
 * Write public static method with string argument
 * Return enum from Map using string argument passed
 *
 * Reference
 * https://dzone.com/articles/java-enum-lookup-by-name-or-field-without-throwing
 */
public class EnumLookUp {

	/**
	* Best implementation - using static HashMap
	* Steps: 
	* 1. Create static HashMap in Enum
	* 2. write static block and initialize HashMap
	* 3. write a static method lookupName(String name) and return the Enum object using name
	*/
	@Test
	public void lookupMap() {
		String name = "Heart";
		CardSuitEnum cardSuitEnum = CardSuitEnum.lookupByName(name);
		System.out.println("cardSuitEnum: " + cardSuitEnum);
	}
}
