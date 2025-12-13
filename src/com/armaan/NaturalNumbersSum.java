package com.armaan;
import java.util.Scanner;

public class NaturalNumbersSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        int n = sc.nextInt();

        int sum = 0;

        System.out.println("First " + n + " natural numbers:");

        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
            sum = sum + i;   // add each number
        }

        System.out.println("\nSum = " + sum);

        sc.close();
    }
}

