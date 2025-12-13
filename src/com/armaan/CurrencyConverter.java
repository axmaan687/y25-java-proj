package com.armaan;
import java.util.Scanner;
class CurrencyConverter {
    private double inr;
    public CurrencyConverter(double inr) {
        this.inr = inr;
    }
    public double toUSD() {
        return inr / 82.0; // Example conversion rate
    }
    public double toEUR() {
        return inr / 90.0; // Example conversion rate
    }
    public double toGBP() {
        return inr / 100.0; // Example conversion rate
    }
    public double toJPY() {
        return inr / 0.62; // Example conversion rate
    }
    public void displayConversion() {
        System.out.println("INR " + inr + " = " + toUSD() + " USD");
        System.out.println("INR " + inr + " = " + toEUR() + " EUR");
        System.out.println("INR " + inr + " = " + toGBP() + " GBP");
        System.out.println("INR " + inr + " = " + toJPY() + " JPY");
    }
}
public class CurrencyConverterMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter amount in INR: ");
        double amount = input.nextDouble();

        CurrencyConverter converter = new CurrencyConverter(amount);
        converter.displayConversion();
        input.close();
    }
}