package com.armaan;

import java.util.Scanner;
public class MatrixSymmetric {
    public static boolean isSymmetric(int[][] matrix) {
        int n = matrix.length;
        for (int[] row : matrix) {
            if (row.length != n) {
                System.out.println("Matrix is not square, hence cannot be symmetric.");
                return false;  }}
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;  }  } }
        return true; }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%5d", value);  }
            System.out.println();  } }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows (and columns) for the square matrix: ");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        System.out.println("Enter elements of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();}  }
        System.out.println("\nMatrix:");
        printMatrix(matrix);
        if (isSymmetric(matrix)) {
            System.out.println("\n✅ The matrix is symmetric.");
        } else {
            System.out.println("\n❌ The matrix is not symmetric.");
        }
        sc.close();
    }
}
