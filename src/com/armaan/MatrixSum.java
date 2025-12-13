package com.armaan;
import java.util.Scanner;

public class MatrixSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = input.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = input.nextInt();

        int boundarySum = 0;
        int diagonalSum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Boundary elements
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1)
                    boundarySum += matrix[i][j];

                // Diagonal elements (only for square matrix)
                if (rows == cols && (i == j || i + j == rows - 1))
                    diagonalSum += matrix[i][j];
            }
        }

        System.out.println("Boundary Sum: " + boundarySum);
        if (rows == cols)
            System.out.println("Diagonal Sum: " + diagonalSum);
        else
            System.out.println("Diagonal sum only calculated for square matrices.");

        input.close();
    }
}