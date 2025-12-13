package com.armaan;
import java.util.Scanner;

public class SimpleArithmeticExpression {
    public static void main(String[] args) {
        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Input three numbers
        System.out.print("Enter the first number (a): ");
        double a = scanner.nextDouble();

        System.out.print("Enter the second number (b): ");
        double b = scanner.nextDouble();

        System.out.print("Enter the third number (c): ");
        double c = scanner.nextDouble();

        // Compute the expression (a + b - c) × 2
        double result = (a + b - c) * 2;

        // Display the result
        System.out.println("\nResult of (a + b - c) × 2 = " + result);

        // Close the scanner
        scanner.close();
    }
}
