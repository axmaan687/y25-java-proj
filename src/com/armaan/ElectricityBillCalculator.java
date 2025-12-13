package com.armaan;

import java.util.Scanner;
public class ElectricityBillCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Electricity Bill Calculator ===");
        // Input consumer details
        System.out.print("Enter Consumer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Consumer ID: ");
        String id = sc.nextLine();
        System.out.print("Enter total units consumed: ");
        double units = sc.nextDouble();
        double amount = 0;
        // Slab-wise calculation
        if (units <= 100) {
            amount = units * 1.50;
        } else if (units <= 200) {
            amount = (100 * 1.50) + (units - 100) * 2.50;
        } else if (units <= 300) {
            amount = (100 * 1.50) + (100 * 2.50) + (units - 200) * 4.00;
        } else {
            amount = (100 * 1.50) + (100 * 2.50) + (100 * 4.00) + (units - 300) * 5.00;
        }
        // Add fixed charge
        double fixedCharge = 50.00;
        double totalBill = amount + fixedCharge;
        // Display Bill
        System.out.println("\n=== ELECTRICITY BILL ===");
        System.out.println("Consumer Name : " + name);
        System.out.println("Consumer ID   : " + id);
        System.out.println("Units Consumed: " + units);
        System.out.println("----------------------------");
        System.out.printf("Energy Charge : ₹%.2f\n", amount);
        System.out.printf("Fixed Charge  : ₹%.2f\n", fixedCharge);
        System.out.println("----------------------------");
        System.out.printf("Total Bill    : ₹%.2f\n", totalBill);
        sc.close();
    }
}

