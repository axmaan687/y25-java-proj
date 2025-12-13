package com.armaan;
import java.util.Scanner;
public class PowerUsingRecursion {
    // Recursive method to calculate x^n
    public static double power(double x, int n) {
        if (n == 0)
            return 1;
        else if (n > 0)
            return x * power(x, n - 1);
        else
            return 1 / power(x, -n); // handle negative powers
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter base (x): ");
        double x = input.nextDouble();
        System.out.print("Enter exponent (n): ");
        int n = input.nextInt();
        double result = power(x, n);
        System.out.println(x + " raised to the power " + n + " is: " + result);
        input.close();
    }
}