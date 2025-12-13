package com.armaan;
import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int sum = 0;

        // Find divisors
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;  // add divisor
            }
        }

        // Check perfect number
        if (sum == num) {
            System.out.println(num + " is a Perfect Number.");
        } else {
            System.out.println(num + " is NOT a Perfect Number.");
        }

        sc.close();
    }
}
