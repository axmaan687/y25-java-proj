package com.armaan;

import java.util.Scanner;
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();
        double totalMarks = 0;
        // Input marks for each subject
        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            double marks = sc.nextDouble();
            // Validate marks
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Please enter between 0 and 100.");
                i--; // Repeat this subject input
                continue;
            }
            totalMarks += marks;
        }
        // Calculate percentage
        double percentage = totalMarks / subjects;
        // Determine grade
        String grade;
        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
        // Display results
        System.out.println("\n===== GRADE REPORT =====");
        System.out.println("Total Marks: " + totalMarks + " / " + (subjects * 100));
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Grade: " + grade);
        sc.close();
    }
}

