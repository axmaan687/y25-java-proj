package com.armaan;
import java.util.Scanner;

public class SumofSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        int N = sc.nextInt();

        int sum = 0;

        for (int i = 1; i <= N; i++) {
            sum += i * i;   // adding square of each number
        }

        System.out.println("Sum of series 1^2 + 2^2 + ... + " + N + "^2 = " + sum);
    }
}
