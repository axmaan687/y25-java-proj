package com.armaan;

import java.util.Scanner;

public class GSTandDiscountPriceCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input cost price, discount, and GST
        System.out.print("Enter Cost Price: ");
        double costPrice = sc.nextDouble();

        System.out.print("Enter Discount Percentage (%): ");
        double discountPercent = sc.nextDouble();

        System.out.print("Enter GST Percentage (%): ");
        double gstPercent = sc.nextDouble();

        // Calculate discount amount
        double discountAmount = (discountPercent / 100) * costPrice;
        double priceAfterDiscount = costPrice - discountAmount;

        // Calculate GST amount
        double gstAmount = (gstPercent / 100) * priceAfterDiscount;

        // Calculate final price
        double finalPrice = priceAfterDiscount + gstAmount;

        // Display results
        System.out.println("\n--- Price Calculation ---");
        System.out.println("Cost Price: " + costPrice);
        System.out.println("Discount Amount: " + discountAmount);
        System.out.println("Price after Discount: " + priceAfterDiscount);
        System.out.println("GST Amount: " + gstAmount);
        System.out.println("Final Price: " + finalPrice);

        sc.close();
    }
}
