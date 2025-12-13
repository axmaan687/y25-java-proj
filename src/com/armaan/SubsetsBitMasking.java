package com.armaan;
import java.util.Scanner;

public class SubsetsBitMasking {

    public static void generateSubsets(int[] set) {
        int n = set.length;
        int totalSubsets = 1 << n; // 2^n subsets

        System.out.println("All subsets of the given set are:");

        for (int mask = 0; mask < totalSubsets; mask++) {
            System.out.print("{ ");
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) { // Check if ith bit is set
                    System.out.print(set[i] + " ");
                }
            }
            System.out.println("}");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in the set: ");
        int n = sc.nextInt();

        int[] set = new int[n];
        System.out.println("Enter elements of the set:");
        for (int i = 0; i < n; i++) {
            set[i] = sc.nextInt();
        }

        generateSubsets(set);

        sc.close();
    }
}
