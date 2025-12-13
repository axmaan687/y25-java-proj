package com.armaan;
import java.util.Scanner;
class Fraction {
    private int numerator;
    private int denominator;
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero.");
        this.numerator = numerator;
        this.denominator = denominator;
        simplify(); }
    private void simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) { // keep denominator positive
            numerator = -numerator;
            denominator = -denominator; }}
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);}
    public Fraction add(Fraction other) {
        int newNum = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDen = this.denominator * other.denominator;
        return new Fraction(newNum, newDen); }
    public void display() {
        if (denominator == 1) System.out.println(numerator);
        else System.out.println(numerator + "/" + denominator); }}
public class FractionTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first fraction:");
        System.out.print("Numerator: ");
        int n1 = sc.nextInt();
        System.out.print("Denominator: ");
        int d1 = sc.nextInt();
        System.out.println("Enter second fraction:");
        System.out.print("Numerator: ");
        int n2 = sc.nextInt();
        System.out.print("Denominator: ");
        int d2 = sc.nextInt();
        Fraction f1 = new Fraction(n1, d1);
        Fraction f2 = new Fraction(n2, d2);
        Fraction sum = f1.add(f2);
        System.out.print("Sum of fractions: ");
        sum.display();
        sc.close();
    }
}
