package com.java.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.junit.Test;

public class ReadInputFromKeyboard {

	// using java.util.Scanner
	@Test
	public void readInputFromKeyboard1() {
		Scanner scanner = new Scanner(System.in); // can be used with try-with-resource
		String val = scanner.nextLine();
		System.out.println(val);
		scanner.close();
	}

	@Test
	public void readInput2() {
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNext()) {
				String val = scanner.nextLine();
				System.out.println(val);
			}
		}
	}

	@Test
	public void readInput3() {
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			String val = bufferedReader.readLine();
			System.out.println(val);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void readInput4() {
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			String val = "";
			do {
				val = bufferedReader.readLine();
				System.out.println(val);
			} while (!"close".equalsIgnoreCase(val));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}