package com.armaan;
import java.util.Scanner;
public class LargestRowColumnSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        int[][] arr = new int[rows][cols];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int maxRowSum = Integer.MIN_VALUE;
        int maxRowIndex = -1;
        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < cols; j++) {
                rowSum += arr[i][j];
            }
            if (rowSum > maxRowSum) {
                maxRowSum = rowSum;
                maxRowIndex = i;
            }
        }
        int maxColSum = Integer.MIN_VALUE;
        int maxColIndex = -1;
        for (int j = 0; j < cols; j++) {
            int colSum = 0;
            for (int i = 0; i < rows; i++) {
                colSum += arr[i][j];
            }
            if (colSum > maxColSum) {
                maxColSum = colSum;
                maxColIndex = j;
            }
        }
        System.out.println("\nRow with largest sum: Row " + (maxRowIndex + 1) + " = " + maxRowSum);
        System.out.println("Column with largest sum: Column " + (maxColIndex + 1) + " = " + maxColSum);
    }
}
