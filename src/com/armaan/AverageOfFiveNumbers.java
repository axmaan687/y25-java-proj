package com.armaan;

import java.util.Scanner;

public class AverageOfFiveNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double sum = 0;
        double number;

        System.out.println("Enter 5 numbers:");

        // Read 5 numbers using a loop
        for (int i = 1; i <= 5; i++) {
            System.out.print("Number " + i + ": ");
            number = sc.nextDouble();
            sum += number;
        }

        // Calculate average
        double average = sum / 5;

        // Display the result
        System.out.println("The average of the five numbers is: " + average);

        sc.close();
    }
}

