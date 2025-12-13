package com.armaan;
import java.util.Scanner;

public class GCDandLCMofTwoNumber {
    
    // Method to compute GCD using Euclidean Algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Method to compute LCM using the relation: LCM(a, b) = (a * b) / GCD(a, b)
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        int resultGCD = gcd(num1, num2);
        int resultLCM = lcm(num1, num2);

        System.out.println("GCD of " + num1 + " and " + num2 + " = " + resultGCD);
        System.out.println("LCM of " + num1 + " and " + num2 + " = " + resultLCM);
    }
}
