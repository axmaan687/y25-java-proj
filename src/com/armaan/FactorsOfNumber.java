package com.armaan;
import java.util.Scanner;

public class FactorsOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("Factors of " + num + " are:");

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {   // if i divides num
                System.out.println(i);
            }
        }

        sc.close();
    }
}
