package com.armaan;
import java.util.Scanner;

public class SumofDigitsUsingRecursion {
    // Recursive method to calculate sum of digits
    public static int sumOfDigits(int n) {
        if (n == 0)
            return 0;
        else
            return n % 10 + sumOfDigits(n / 10);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = input.nextInt();

        int sum = sumOfDigits(num);
        System.out.println("Sum of digits of " + num + " is: " + sum);

        input.close();
    }
}