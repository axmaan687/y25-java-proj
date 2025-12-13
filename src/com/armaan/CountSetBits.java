package com.armaan;
import java.util.Scanner;

public class CountSetBits {

    // Function to count set bits using Brian Kernighan’s Algorithm
    public static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1); // clear the rightmost set bit
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int setBits = countSetBits(num);
        System.out.println("Number of set bits in " + num + " is: " + setBits);

        sc.close();
    }
}
