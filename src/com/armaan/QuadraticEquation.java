package com.armaan;
import java.util.Scanner;
class QuadraticEquation {
    private double a, b, c;
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double discriminant() {
        return b * b - 4 * a * c;
    }
    public void computeRoots() {
        double d = discriminant();
        if (d > 0) {
            double root1 = (-b + Math.sqrt(d)) / (2 * a);
            double root2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("Two real roots: " + root1 + " and " + root2);
        } else if (d == 0) {
            double root = -b / (2 * a);
            System.out.println("One real root: " + root);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-d) / (2 * a);
            System.out.println("Complex roots: " + realPart + " + " + imaginaryPart + "i and "
                    + realPart + " - " + imaginaryPart + "i");
        }}}
public class QuadraticEquationTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter coefficient a: ");
        double a = sc.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = sc.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = sc.nextDouble();
        QuadraticEquation qe = new QuadraticEquation(a, b, c);
        System.out.println("Discriminant: " + qe.discriminant());
        qe.computeRoots();
        sc.close();
    }
}
