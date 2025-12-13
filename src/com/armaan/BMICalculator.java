package com.armaan;
import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter your weight (in kilograms): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter your height (in meters): ");
        double height = scanner.nextDouble();

        // Compute BMI
        double bmi = weight / (height * height);

        // Output
        System.out.printf("Your BMI is: %.2f\n", bmi);

        // Interpretation (optional)
        if (bmi < 18.5) {
            System.out.println("Status: Underweight");
        } else if (bmi < 25) {
            System.out.println("Status: Normal weight");
        } else if (bmi < 30) {
            System.out.println("Status: Overweight");
        } else {
            System.out.println("Status: Obese");
        }

        scanner.close();
    }
}
