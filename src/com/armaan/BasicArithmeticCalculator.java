package com.armaan;

import java.util.Scanner;
public class BasicArithmeticCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept two numbers
        System.out.print("Enter the first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = sc.nextDouble();

        // Perform arithmetic operations
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = 0;
        double remainder = 0;

        if (num2 != 0) {
            quotient = num1 / num2;
            remainder = num1 % num2;
        } else {
            System.out.println("Warning: Division by zero is not allowed for quotient and remainder.");
        }

        // Display results
        System.out.println("\n--- Arithmetic Operations ---");
        System.out.println("Sum = " + sum);
        System.out.println("Difference = " + difference);
        System.out.println("Product = " + product);
        if (num2 != 0) {
            System.out.println("Quotient = " + quotient);
            System.out.println("Remainder = " + remainder);
        }

        sc.close();
    }
}

