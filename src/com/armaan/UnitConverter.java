package com.armaan;

import java.util.Scanner;

public class UnitConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Unit Converter ---");

        // Convert centimeters to meters
        System.out.print("Enter length in centimeters: ");
        double centimeters = sc.nextDouble();
        double meters = centimeters / 100;
        System.out.println(centimeters + " cm = " + meters + " m");

        // Convert kilograms to grams
        System.out.print("\nEnter weight in kilograms: ");
        double kilograms = sc.nextDouble();
        double grams = kilograms * 1000;
        System.out.println(kilograms + " kg = " + grams + " g");

        sc.close();
    }
}
