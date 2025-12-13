package com.armaan;

import java.util.Scanner;
import java.util.Arrays;
public class LargestSmallestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        if (n < 2) {
            System.out.println("At least two elements are required!");
            return;
        }
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int smallest = arr[0];
        int secondSmallest = Integer.MIN_VALUE;
        int largest = arr[n - 1];
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (arr[i] != smallest) {
                secondSmallest = arr[i];
                break;
            }  }
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] != largest) {
                secondLargest = arr[i];
                break;
            }  }
        System.out.println("\n===== RESULTS =====");
        if (secondSmallest == Integer.MIN_VALUE)
            System.out.println("No distinct second smallest element (all elements are equal).");
        else
            System.out.println("Second Smallest: " + secondSmallest);
        if (secondLargest == Integer.MIN_VALUE)
            System.out.println("No distinct second largest element (all elements are equal).");
        else
            System.out.println("Second Largest: " + secondLargest);
        sc.close();
    }
}
