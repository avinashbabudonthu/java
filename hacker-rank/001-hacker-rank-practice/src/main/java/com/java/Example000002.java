package com.java;

import java.util.Scanner;

/**
 * Sample Input
 *
 * java 100
 * cpp 65
 * python 50
 * Sample Output
 *
 * ================================
 * java           100
 * cpp            065
 * python         050
 * ================================
 */
public class Example000002 {

    public static void main(String[] args) {
        new Example000002().execute();
    }

    private void execute() {
        try (Scanner scanner = new Scanner(System.in);) {
            String s1 = scanner.next();
            int x1 = scanner.nextInt();

            System.out.println(s1);
            System.out.println(x1);

            String s2 = String.format("%15s", s1);
            System.out.println("-" + s2 + "-");

            String s3 = String.format("%-15s", s1);
            System.out.println("-" + s3 + "-");

            String x2 = String.format("%15d", x1);
            System.out.println("-" + x2 + "-");

            String x3 = String.format("%-15d", x1);
            System.out.println("-" + x3 + "-");

            String x4 = String.format("%015d", x1);
            System.out.println("-" + x4 + "-");
        }
    }
}
