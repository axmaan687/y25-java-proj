package com.armaan;
import java.util.Scanner;

public class ReverseAndPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int original = num;
        int rev = 0;

        // Reverse the number
        while (num > 0) {
            int digit = num % 10;        // get last digit
            rev = rev * 10 + digit;      // append digit to reversed number
            num = num / 10;              // remove last digit
        }

        System.out.println("Reversed number: " + rev);

        // Check palindrome
        if (original == rev) {
            System.out.println(original + " is a Palindrome number.");
        } else {
            System.out.println(original + " is NOT a Palindrome number.");
        }

        sc.close();
    }
}
