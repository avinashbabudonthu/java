package com.cerebro.srp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution1 {

	public static final int THRESHOLD = 5;

	public static void main(String[] args) {
		System.out.println("Welcome to the Application!");

		List<Integer> nums = readNumbers();
		Collections.sort(nums);
		printNumbers(nums);
	}

	private static void printNumbers(List<Integer> nums) {
		for (int num : nums)
			System.out.print(num + " ");
	}

	private static List<Integer> readNumbers() {
		System.out.println("Enter 5 valid integers in the range [0, 10]");

		Scanner scanner = new Scanner(System.in);

		List<Integer> nums = new ArrayList<>();

		while (nums.size() < THRESHOLD) {

			String s = scanner.nextLine();

			if (!isValidNumber(s)) {
				continue;
			}

			int num = Integer.parseInt(s);
			if (!isValidRange(num)) {
				continue;
			}

			nums.add(num);
		}

		scanner.close();

		return nums;
	}

	private static boolean isValidNumber(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			System.out.println("Invalid! Try again!");
			return false;
		}

		return true;
	}

	private static boolean isValidRange(Integer num) {
		if (num < 0 || num > 10) {
			System.out.println("Invalid range! Try again!");
			return false;
		}
		return true;
	}

}
