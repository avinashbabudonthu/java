package com.java;

import org.junit.Test;

import java.util.Scanner;

/**
 * Task
 * Given an integer, , perform the following conditional actions:
 * <p>
 * If  is odd, print Weird
 * If  is even and in the inclusive range of  to , print Not Weird
 * If  is even and in the inclusive range of  to , print Weird
 * If  is even and greater than , print Not Weird
 * Complete the stub code provided in your editor to print whether or not  is weird.
 * <p>
 * Input Format
 * <p>
 * A single line containing a positive integer, .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print Weird if the number is weird; otherwise, print Not Weird.
 * <p>
 * Sample Input 0
 * <p>
 * 3
 * Sample Output 0
 * <p>
 * Weird
 * Sample Input 1
 * <p>
 * 24
 * Sample Output 1
 * <p>
 * Not Weird
 * Explanation
 * <p>
 * Sample Case 0:
 * is odd and odd numbers are weird, so we print Weird.
 * <p>
 * Sample Case 1:
 * and  is even, so it isn't weird. Thus, we print Not Weird.
 */
public class Example000001 {

    public static void main(String[] args) {
        new Example000001().execute();
    }

//    @Test
    public void execute() {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            int n = Integer.parseInt(input);

            if(n == 0) {
                scanner.close();
                System.exit(0);
            }

            int reminder = n % 2;

            if(reminder == 1) {
                System.out.println("Weird");
            } else {
                System.out.println("Not Weird");
            }

        }

    }

}