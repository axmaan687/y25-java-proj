package com.armaan;
import java.util.Scanner;
public class SpiralOrderMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int m = input.nextInt();
        System.out.print("Enter number of columns: ");
        int n = input.nextInt();
        int[][] matrix = new int[m][n];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = input.nextInt();
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        System.out.println("Spiral Order:");
        while (top <= bottom && left <= right) {
            // Print top row
            for (int i = left; i <= right; i++)
                System.out.print(matrix[top][i] + " ");
            top++;
            // Print right column
            for (int i = top; i <= bottom; i++)
                System.out.print(matrix[i][right] + " ");
            right--;
            // Print bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    System.out.print(matrix[bottom][i] + " ");
                bottom--;
            }
            // Print left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    System.out.print(matrix[i][left] + " ");
                left++;
            }
        }
        input.close();
    }
}