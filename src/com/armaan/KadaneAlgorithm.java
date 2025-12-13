package com.armaan;
import java.util.Scanner;

public class KadaneAlgorithm {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int maxSoFar = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < n; i++) {
            // Either extend current subarray or start new subarray
            currentSum = Math.max(arr[i], currentSum + arr[i]);

            // Update global maximum
            maxSoFar = Math.max(maxSoFar, currentSum);
        }

        System.out.println("Maximum Subarray Sum = " + maxSoFar);
    }
}
