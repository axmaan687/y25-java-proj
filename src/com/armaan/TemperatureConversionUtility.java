package com.armaan;
import java.util.Scanner;

public class TemperatureConversionUtility {
		    // Conversion methods
		    public static double celsiusToFahrenheit(double c) {
		        return (c * 9 / 5) + 32;
		    }

		    public static double celsiusToKelvin(double c) {
		        return c + 273.15;
		    }

		    public static double fahrenheitToCelsius(double f) {
		        return (f - 32) * 5 / 9;
		    }

		    public static double fahrenheitToKelvin(double f) {
		        return (f - 32) * 5 / 9 + 273.15;
		    }

		    public static double kelvinToCelsius(double k) {
		        return k - 273.15;
		    }

		    public static double kelvinToFahrenheit(double k) {
		        return (k - 273.15) * 9 / 5 + 32;
		    }

		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);

		        System.out.println("=== Temperature Converter ===");
		        System.out.print("Enter temperature value: ");
		        double value = scanner.nextDouble();

		        System.out.print("Enter the scale (C for Celsius, F for Fahrenheit, K for Kelvin): ");
		        char scale = scanner.next().toUpperCase().charAt(0);

		        switch (scale) {
		            case 'C':
		                System.out.printf("%.2f °C = %.2f °F%n", value, celsiusToFahrenheit(value));
		                System.out.printf("%.2f °C = %.2f K%n", value, celsiusToKelvin(value));
		                break;

		            case 'F':
		                System.out.printf("%.2f °F = %.2f °C%n", value, fahrenheitToCelsius(value));
		                System.out.printf("%.2f °F = %.2f K%n", value, fahrenheitToKelvin(value));
		                break;

		            case 'K':
		                System.out.printf("%.2f K = %.2f °C%n", value, kelvinToCelsius(value));
		                System.out.printf("%.2f K = %.2f °F%n", value, kelvinToFahrenheit(value));
		                break;

		            default:
		                System.out.println("Invalid scale! Please enter C, F, or K.");
		        }

		        scanner.close();
		    }


	}