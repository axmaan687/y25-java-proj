package com.armaan;
import java.util.Scanner;

public class PrimeNumberUpToN {

    // Method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        int N = input.nextInt();

        System.out.println("Prime numbers up to " + N + ":");

        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }

        input.close();
    }
}