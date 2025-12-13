package com.armaan;

import java.util.Arrays;
import java.util.Scanner;
public class MeanMedianMode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Number of elements must be greater than zero!");
            return; }
        double[] numbers = new double[n];
        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextDouble(); }
        Arrays.sort(numbers);
        double sum = 0;
        for (double num : numbers) {
            sum += num; }
        double mean = sum / n;
        double median;
        if (n % 2 == 0) {
            median = (numbers[n / 2 - 1] + numbers[n / 2]) / 2.0;  } else {
            median = numbers[n / 2]; }
        double mode = Double.NaN; // Not a Number (if no mode exists)
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (numbers[j] == numbers[i]) {
                    count++;  }  }
            if (count > maxCount) {
                maxCount = count;
                mode = numbers[i]; } }
        boolean unique = true;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (numbers[j] == numbers[i]) count++; }
            if (count > 1) {
                unique = false;
                break; } }
        System.out.println("\n===== RESULTS =====");
        System.out.printf("Mean   = %.2f%n", mean);
        System.out.printf("Median = %.2f%n", median);
        if (unique)
            System.out.println("Mode   = No mode (all elements are unique)");
        else
            System.out.printf("Mode   = %.2f%n", mode);
        sc.close();
    }
}

