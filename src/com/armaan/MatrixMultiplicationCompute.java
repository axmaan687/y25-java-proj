package com.armaan;

import java.util.Scanner;
public class MatrixMultiplicationCompute {
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;
        if (colsA != rowsB) {
            throw new IllegalArgumentException("Matrix dimensions are not compatible for multiplication."); }
        int[][] C = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }}  }
        return C;  }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%6d", value); }
            System.out.println();   }}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and columns for matrix A: ");
        int rowsA = sc.nextInt();
        int colsA = sc.nextInt();
        System.out.print("Enter rows and columns for matrix B: ");
        int rowsB = sc.nextInt();
        int colsB = sc.nextInt();
        int[][] A = new int[rowsA][colsA];
        int[][] B = new int[rowsB][colsB];
        System.out.println("Enter elements of matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                A[i][j] = sc.nextInt();} }
        System.out.println("Enter elements of matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                B[i][j] = sc.nextInt(); } }
        try {
            int[][] C = multiplyMatrices(A, B);
            System.out.println("\nMatrix A:");
            printMatrix(A);
            System.out.println("\nMatrix B:");
            printMatrix(B);
            System.out.println("\nProduct (C = A × B):");
            printMatrix(C);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); }
        sc.close();
    }
}

