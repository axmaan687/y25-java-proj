package com.armaan;

import java.util.Scanner;
public class SpeedTimeDistanceCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Find the missing value:");
        System.out.println("1. Speed");
        System.out.println("2. Time");
        System.out.println("3. Distance");
        System.out.print("Enter your choice (1/2/3): ");
        int choice = sc.nextInt();
        double speed, time, distance;
        if (choice == 1) { // Find Speed
            System.out.print("Enter Distance: ");
            distance = sc.nextDouble();
            System.out.print("Enter Time: ");
            time = sc.nextDouble();
            speed = distance / time;
            System.out.println("Speed = " + speed);
        } 
        else if (choice == 2) { // Find Time
            System.out.print("Enter Distance: ");
            distance = sc.nextDouble();
            System.out.print("Enter Speed: ");
            speed = sc.nextDouble();
            time = distance / speed;
            System.out.println("Time = " + time);
        } 
        else if (choice == 3) { // Find Distance
            System.out.print("Enter Speed: ");
            speed = sc.nextDouble();
            System.out.print("Enter Time: ");
            time = sc.nextDouble();
            distance = speed * time;
            System.out.println("Distance = " + distance);
        } 
        else {
            System.out.println("Invalid choice!");
        }
        sc.close();
    }
}

