package com.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class ArraysPractice {

	@SuppressWarnings("unused")
	@Test
	public void createArray() {
		// int array
		int[] intArray = new int[10];

		// float array
		float[] floatArray = new float[10];

		// double array
		double[] doubleArray = new double[10];

		// char array
		char[] charArray = new char[10];

		// String array
		String[] stringArray = new String[10];

		// custom class array
		Student[] studentArray = new Student[10];
	}

	@Test
	public void assignValuesToArray() {
		// int array
		int[] intArray = new int[10];
		intArray[0] = 0;
		intArray[1] = 1;

		int[] intArray2 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// float array
		float[] floatArray = new float[10];
		floatArray[0] = 1.23f;
		floatArray[1] = 1.24f;

		// double array
		double[] doubleArray = new double[10];
		doubleArray[0] = 1.23;
		doubleArray[1] = 1.24;

		// char array
		char[] charArray = new char[10];
		charArray[0] = 'a';
		charArray[1] = 'b';

		// String array
		String[] stringArray = new String[10];
		stringArray[0] = "jack";
		stringArray[1] = "jill";

		// custom class array
		Student[] studentArray = new Student[10];
		studentArray[0] = new Student();
		studentArray[1] = new Student();
	}

	@Test
	public void arrayLength() {
		// int array
		int[] intArray = new int[10];
		intArray[0] = 0;
		intArray[1] = 1;

		// String array
		String[] stringArray = new String[10];
		stringArray[0] = "jack";
		stringArray[1] = "jill";
		stringArray[2] = "john";

		// custom class array
		Student[] studentArray = new Student[10];
		studentArray[0] = new Student();
		studentArray[1] = new Student();
		studentArray[2] = new Student();
		studentArray[3] = new Student();

		log.info("int array length={}", intArray.length);
		log.info("string array length={}", stringArray.length);
		log.info("student array length={}", studentArray.length);
	}

	@Test
	public void iterateArray() {
		// int array
		int[] intArray = new int[10];
		intArray[0] = 1;
		intArray[1] = 2;
		intArray[2] = 3;
		intArray[3] = 4;

		// print array directly
		System.out.println(intArray);

		// using for loop
		log.info("using for loop");
		for (int i = 0; i < intArray.length; i++) {
			log.info("{}", intArray[i]);
		}

		// using for each loop
		log.info("using for each loop");
		for (int i : intArray) {
			log.info("{}", i);
		}

		// using stream from java 8
		log.info("using java 8 streams");
		Arrays.stream(intArray).boxed().forEach(i -> log.info("{}", i));

		// custom class array
		Student[] studentArray = new Student[10];
		studentArray[0] = new Student();
		studentArray[1] = new Student();
		studentArray[2] = new Student();
		studentArray[3] = new Student();

		// using for loop
		log.info("using for loop");
		for (int i = 0; i < intArray.length; i++) {
			log.info("{}", studentArray[i]);
		}

		// using for each loop
		log.info("using for each loop");
		for (Student student : studentArray) {
			log.info("{}", student);
		}

		// using stream from java 8
		log.info("using java 8 streams");
		Arrays.stream(studentArray).forEach(i -> log.info("{}", i));
	}

	/**
	 * 1. list does not support operations like add, remove, set
	 *  because unlike normal list the size of this list is fixed and size equal to the
	 *  number of elements of array
	 * 2. If we perform any add, remove etc operation on this list then
	 *  java.lang.UpsupportedOperationException will be thrown
	 */
	@Test
	public void convertArrayToList() {
		String[] stringArray = { "a", "b", "c", "d", "e" };
		List<String> list = Arrays.asList(stringArray);
		log.info("list={}", list);
	}

	@Test
	public void arrayStoreException() {
		String[] strArray = new String[3];
		Object[] objArray = strArray;
		objArray[0] = "1";

		try {
			objArray[0] = 2;
		} catch (Exception e) {
			log.error("Exception", e);
		}
	}

	@Test
	public void parallelSortPractice() {
		int[] intArray = new int[] { 5, 8, 6, 7, 9, 4, 2, 3, 0, 1 };

		String result;

		result = Arrays.stream(intArray).boxed().map(String::valueOf).collect(Collectors.joining(","));
		System.out.println("intArray before sorting: " + result);

		Arrays.parallelSort(intArray);
		result = Arrays.stream(intArray).boxed().map(String::valueOf).collect(Collectors.joining(","));
		System.out.println("intArray after sorting: " + result);

		// with external comparator
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str2.compareTo(str1);
			}
		};
		String[] strArray = new String[] { "def", "ghi", "abc", "wer" };
		result = Arrays.stream(strArray).collect(Collectors.joining(","));
		System.out.println("strArray before sorting: " + result);

		Arrays.parallelSort(strArray, comparator);
		result = Arrays.stream(strArray).collect(Collectors.joining(","));
		System.out.println("strArray after sorting: " + result);

		// with lambda expression
		String[] strArray2 = new String[] { "weqwqew", "avdas", "desf", "abqwec" };
		Comparator<String> lengthComparator = (str1, str2) -> Integer.valueOf(str1.length()).compareTo(str2.length());
		Arrays.parallelSort(strArray2, lengthComparator);
		result = Arrays.stream(strArray2).collect(Collectors.joining(","));
		System.out.println("strArray2 after length sorting using lambda: " + result);
	}

	@Test
	public void parallelSetAllPractice() {
		String[] names = new String[] { "jack", "john", "jay", "jim" };
		System.out.println("names: before: " + Arrays.stream(names).collect(Collectors.joining(",")));

		Arrays.parallelSetAll(names, index -> "Hi " + names[index]);
		System.out.println("names: after: " + Arrays.stream(names).collect(Collectors.joining(",")));

		Arrays.setAll(names, index -> "Hello " + names[index]);
		System.out.println("names: after: " + Arrays.stream(names).collect(Collectors.joining(",")));
	}

	@Test
	public void parallelPrefixPractice() {
		String[] names = new String[] { "jack", "john", "jay", "jim", "jill", "jane" };
		System.out.println("names: before: " + Arrays.stream(names).collect(Collectors.joining(",")));
		Arrays.parallelPrefix(names, (x, y) -> x + "-" + y);
		System.out.println("names: after: " + Arrays.stream(names).collect(Collectors.joining(",")));

		names = new String[] { "jack", "john", "jay", "jim", "jill", "jane" };
		System.out.println("names: before: " + Arrays.stream(names).collect(Collectors.joining(",")));
		Arrays.parallelPrefix(names, 1, 3, (x, y) -> x + "-" + y);
		System.out.println("names: after: " + Arrays.stream(names).collect(Collectors.joining(",")));

	}

	/*
	 * Arrays.deepEquals(null, null) : true
		Arrays.deepEquals(array1, null) : false
		Arrays.deepEquals(array1, array2) : true
		Arrays.deepEquals(array1, array3) : false
	 */
	@Test
	public void deepEqualsPractice() {
		Integer[] array1 = new Integer[] { 1, 2, 3, 4, 5 };
		Integer[] array2 = new Integer[] { 1, 2, 3, 4, 5 };
		Integer[] array3 = new Integer[] { 6, 7, 8, 9, 0 };

		System.out.println("Arrays.deepEquals(null, null) : " + Arrays.deepEquals(null, null));
		System.out.println("Arrays.deepEquals(array1, null) : " + Arrays.deepEquals(array1, null));
		System.out.println("Arrays.deepEquals(array1, array2) : " + Arrays.deepEquals(array1, array2));
		System.out.println("Arrays.deepEquals(array1, array3) : " + Arrays.deepEquals(array1, array3));
	}

	@Test
	public void hashCodePractice() {
		Integer[] array1 = new Integer[] { 1, 2, 3, 4, 5 };
		System.out.println("Arrays.hashCode(array1) : " + Arrays.hashCode(array1));
	}

	@Test
	public void deepHashCodePractice() {
		Integer[] array1 = new Integer[] { 1, 2, 3, 4, 5 };
		System.out.println("Arrays.deepHashCode(array1) : " + Arrays.deepHashCode(array1));
	}

	/**
	 * Assigns the specified long/int/double value to each element of the specified array of longs/ints/doubles
	 */
	@Test
	public void fill() {
		int[] ints = new int[5];
		Arrays.fill(ints, 1);
		Arrays.stream(ints).boxed().forEach(System.out::println);

		double[] doubles = new double[5];
		Arrays.fill(doubles, 1.2);
		Arrays.stream(doubles).boxed().forEach(System.out::println);
	}

	/*
	 * array elements using for loop:
		value=jack
		value=john
		value=jill
		string representation of array:
		arrayToString=[jack, john, jill]
	 */
	@Test
	public void deepToString() {
		Object[] objectArray = { "jack", "john", "jill" };

		log.info("array elements using for loop:");
		for (Object value : objectArray) {
			log.info("value={}", value);
		}

		log.info("string representation of array:");
		String arrayToString = Arrays.deepToString(objectArray);
		log.info("arrayToString={}", arrayToString);
	}
}