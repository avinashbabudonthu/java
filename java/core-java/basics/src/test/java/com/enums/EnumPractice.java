package com.enums;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.EnumMap;
import java.util.EnumSet;

@Slf4j
public class EnumPractice {

	/**
	 * Access one enum value
	 */
	@Test
	public void accessEnumValue() {
		DaysEnum monday = DaysEnum.MONDAY;
		log.info("monday={}", monday);
	}

	@Test
	public void iterateEnum() {
		for (DaysEnum day : DaysEnum.values()) {
			log.info("day={}", day);
		}
	}

	@Test
	public void enumInIf() {
		DaysEnum monday = DaysEnum.MONDAY;
		DaysEnum tuesday = DaysEnum.TUESDAY;

		if (DaysEnum.MONDAY == monday) {
			log.info("monday");
		} else {
			log.info("not monday");
		}

		if (DaysEnum.MONDAY == tuesday) {
			log.info("tuesday");
		} else {
			log.info("not tuesday");
		}
	}

	@Test
	public void enumInSwitch() {
		DaysEnum monday = DaysEnum.MONDAY;

		switch (monday) {
		case MONDAY:
			System.out.println("monday");
			break;
		case TUESDAY:
			System.out.println("tuesday");
			break;
		default:
			System.out.println("other");
			break;
		}
	}

	@Test
	public void iterateEnumWithArgumentedConstructor() {
		DaysEnum2[] days = DaysEnum2.values();
		for (DaysEnum2 day : days) {
			System.out.println(day.getValue());
		}
	}

	@Test
	public void enumToString() {
		DaysEnum monday = DaysEnum.MONDAY;
		String mondayString = monday.toString();
		System.out.println("mondayString: " + mondayString);
		System.out.println("DaysEnum.MONDAY: " + DaysEnum.MONDAY);
	}

	/** Very poor implementation - not preferable 
	* Using Enum.valueOf is great when you know the input is valid. However, if you pass in an invalid name, 
	* an exception will be thrown. In some cases, this is fine. Oftentimes. we would prefer to just ignore it and return null.
	*/
	@Test
	public void valueOf() {
		DaysEnum monday = DaysEnum.valueOf("MONDAY");
		System.out.println("monday: " + monday);

		try {
			DaysEnum tuesday = DaysEnum.valueOf("tuesday");
			log.info("tuesday={}", tuesday);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void enumMethods() {
		EnumMethods monday = EnumMethods.MONDAY;
		System.out.println("monday: " + monday);
		System.out.println("monday.lowerCase(): " + monday.lowerCase());

		EnumMethods monday2 = EnumMethods.MONDAY;
		System.out.println("monday2.capitalize(): " + monday2.capitalize());
		EnumMethods tuesday = EnumMethods.TUESDAY;
		System.out.println("tuesday.capitalize(): " + tuesday.capitalize());
	}

	@Test
	public void enumImplementingInterface() {
		EnumImpl enumImpl1 = EnumImpl.ONE;

		System.out.println("enumImpl1: " + enumImpl1);
		System.out.println("enumImpl1.getDescription(): " + enumImpl1.getDescription());
	}

	@Test
	public void enumSet() {
		EnumSet<DaysEnum> daysSet = EnumSet.of(DaysEnum.MONDAY, DaysEnum.TUESDAY);
		daysSet.add(DaysEnum.WEDNESDAY);

		System.out.println("daysSet: " + daysSet);
	}

	@Test
	public void enumMap() {
		EnumMap<DaysEnum2, Integer> enumMap = new EnumMap<>(DaysEnum2.class);
		enumMap.put(DaysEnum2.MONDAY, DaysEnum2.MONDAY.getValue());
		enumMap.put(DaysEnum2.TUESDAY, DaysEnum2.TUESDAY.getValue());
		enumMap.put(DaysEnum2.WEDNESDAY, DaysEnum2.WEDNESDAY.getValue());

		System.out.println("enumMap: " + enumMap);
		System.out.println("enumMap.get(DaysEnum2.WEDNESDAY): " + enumMap.get(DaysEnum2.WEDNESDAY));
	}

}