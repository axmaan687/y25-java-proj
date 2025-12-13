package com.armaan;
import java.util.Scanner;
public class FloodFillMatrix {
    static int[] rowDir = {-1, 1, 0, 0};
    static int[] colDir = {0, 0, -1, 1};
    public static void floodFill(int[][] matrix, int x, int y, int oldColor, int newColor) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m) return;
        if (matrix[x][y] != oldColor) return;
        matrix[x][y] = newColor;
        for (int dir = 0; dir < 4; dir++) {
            int newX = x + rowDir[dir];
            int newY = y + colDir[dir];
            floodFill(matrix, newX, newY, oldColor, newColor); }}
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " "); }
            System.out.println(); } }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt(); } }
        System.out.print("Enter starting row for flood-fill: ");
        int startX = sc.nextInt();
        System.out.print("Enter starting column for flood-fill: ");
        int startY = sc.nextInt();
        System.out.print("Enter new color: ");
        int newColor = sc.nextInt();
        int oldColor = matrix[startX][startY];
        if (oldColor != newColor) { // avoid infinite loop if oldColor == newColor
            floodFill(matrix, startX, startY, oldColor, newColor); }
        System.out.println("Matrix after flood-fill:");
        printMatrix(matrix);
        sc.close();
    }
}
