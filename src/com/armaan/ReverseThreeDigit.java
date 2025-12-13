package com.armaan;

import java.util.Scanner;

public class ReverseThreeDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a three-digit number: ");
        int num = sc.nextInt();

        int rev = 0;

        while (num > 0) {
            int digit = num % 10;   // get last digit
            rev = rev * 10 + digit; // add digit to reversed number
            num = num / 10;         // remove last digit
        }

        System.out.println("Reversed number: " + rev);

        sc.close();
    }
}
