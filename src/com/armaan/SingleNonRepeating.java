package com.armaan;
import java.util.Scanner;

public class SingleNonRepeating {

    // Function to find single non-repeating element
    public static int findSingle(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;  // XOR with each element
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements (all except one element appear twice):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int singleElement = findSingle(arr);
        System.out.println("The single non-repeating element is: " + singleElement);

        sc.close();
    }
}
