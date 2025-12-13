package com.armaan;

import java.util.Scanner;
public class RootsOfQuadraticEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Quadratic Equation Solver ===");
        System.out.println("Equation format: ax² + bx + c = 0");
        // Input coefficients
        System.out.print("Enter value of a: ");
        double a = sc.nextDouble();
        System.out.print("Enter value of b: ");
        double b = sc.nextDouble();
        System.out.print("Enter value of c: ");
        double c = sc.nextDouble();
        // Handle invalid input
        if (a == 0) {
            System.out.println("This is not a quadratic equation (a cannot be zero).");
            return;
        }
        // Compute discriminant (b² - 4ac)
        double discriminant = b * b - 4 * a * c;
        System.out.println("\nDiscriminant (D) = " + discriminant);
        // Compute and classify roots
        if (discriminant > 0) {
            // Real and distinct roots
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Roots are REAL and DISTINCT.");
            System.out.printf("Root 1 = %.2f\n", root1);
            System.out.printf("Root 2 = %.2f\n", root2);
        } 
        else if (discriminant == 0) {
            // Real and equal roots
            double root = -b / (2 * a);
            System.out.println("Roots are REAL and EQUAL.");
            System.out.printf("Root 1 = Root 2 = %.2f\n", root);
        } 
        else {
            // Imaginary roots
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            System.out.println("Roots are IMAGINARY and COMPLEX.");
            System.out.printf("Root 1 = %.2f + %.2fi\n", realPart, imaginaryPart);
            System.out.printf("Root 2 = %.2f - %.2fi\n", realPart, imaginaryPart);
        }
        sc.close();
    }
}
