package com.armaan;


import java.util.Scanner;
public class MultiplicationTable {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter a number to print its multiplication table: ");
	        int n = scanner.nextInt();

	        System.out.println("\n=== Multiplication Table of " + n + " ===");

	        for (int i = 1; i <= 10; i++) {
	            System.out.printf("%d × %d = %d%n", n, i, n * i);
	        }

	        scanner.close();
	    }

}