package com.armaan;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ComputeAverageMark {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Array to store {studentIndex, marks}
        int[][] students = new int[n][2];

        int sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks of student " + (i + 1) + ": ");
            int marks = sc.nextInt();
            
            students[i][0] = i + 1;   // student ID
            students[i][1] = marks;   // marks
            
            sum += marks;
        }

        double average = (double) sum / n;

        // Sort students by marks in descending order
        Arrays.sort(students, Comparator.comparingInt(a -> -a[1]));

        System.out.println("\nAverage marks = " + average);

        System.out.println("\nTop 3 Students:");
        for (int i = 0; i < Math.min(3, n); i++) {
            System.out.println("Student " + students[i][0] + " : " + students[i][1] + " marks");
        }
    }
}
