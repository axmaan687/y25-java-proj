package com.armaan;

class Rectangle {
    // Attributes
    double length;
    double width;

    // Constructor
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Method to calculate area
    double getArea() {
        return length * width;
    }

    // Method to calculate perimeter
    double getPerimeter() {
        return 2 * (length + width);
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating object of Rectangle class
        Rectangle rect = new Rectangle(10, 5);

        System.out.println("Length: " + rect.length);
        System.out.println("Width: " + rect.width);
        System.out.println("Area: " + rect.getArea());
        System.out.println("Perimeter: " + rect.getPerimeter());
    }
}