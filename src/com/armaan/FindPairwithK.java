package com.armaan;
import java.util.Scanner;

public class FindPairwithK {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input target sum K
        System.out.print("Enter the value of K: ");
        int K = sc.nextInt();

        System.out.println("Pairs with sum " + K + " are:");

        boolean found = false;

        // Find all pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == K) {
                    System.out.println(arr[i] + " + " + arr[j] + " = " + K);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No pairs found.");
        }
    }
}
