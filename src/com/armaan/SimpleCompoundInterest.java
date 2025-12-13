package com.armaan;

import java.util.Scanner;

public class SimpleCompoundInterest {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Read principal, rate, and time
        System.out.print("Enter Principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter Rate of interest (per annum in %): ");
        double rate = scanner.nextDouble();

        System.out.print("Enter Time (in years): ");
        double time = scanner.nextDouble();

        // Calculate Simple Interest
        double simpleInterest = (principal * rate * time) / 100;

        // Calculate Compound Interest (compounded annually)
        double compoundInterest = principal * Math.pow((1 + rate / 100), time) - principal;

        // Display results
        System.out.println("\n--- Interest Calculation ---");
        System.out.println("Principal: " + principal);
        System.out.println("Rate: " + rate + "%");
        System.out.println("Time: " + time + " year(s)");
        System.out.println("Simple Interest: " + simpleInterest);
        System.out.println("Compound Interest: " + compoundInterest);

        // Close scanner
        scanner.close();
    }
}

