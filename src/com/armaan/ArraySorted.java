package com.armaan;

import java.util.Scanner;
public class ArraySorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Array must contain at least one element!");
            return;
        }
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        boolean ascending = true;
        boolean descending = true;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                ascending = false;
            }
            if (arr[i] < arr[i + 1]) {
                descending = false;
            }
        }

        System.out.println("\n===== RESULT =====");
        if (ascending)
            System.out.println("The array is sorted in ASCENDING order.");
        else if (descending)
            System.out.println("The array is sorted in DESCENDING order.");
        else
            System.out.println("The array is NOT sorted.");

        sc.close();
    }
}
