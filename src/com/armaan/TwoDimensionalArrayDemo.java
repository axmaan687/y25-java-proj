package com.armaan;

public class TwoDimensionalArrayDemo {

	public static void main(String[] args) {
		int a[][] = {{10,20,30},{40,50,60},{70,80,90}};
		System.out.println("Array elements are:");
		for(int i=0;i<3;i++)
		{
		for(int j=0;j<3;j++)
		{
		System.out.print(a[i][j]+"\t");
		}
		System.out.println();
		}
		int[][] b = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("Array Elements are:");
		for(int i=0;i<3;i++)
		{
		for(int j=0;j<3;j++)
		{
		System.out.print(b[i][j]+"\t");
		}
		System.out.println();
		}
		int c[][]=new int[3][2];
		c[0][0]= 5;
		c[0][1]=6;
		c[1][0]= 5;
		c[1][1]=6;
		c[2][0]= 5;
		c[2][1]=6;
		System.out.println("Array Elements are:");
		for(int i=0;i<3;i++)
		{
		for(int j=0;j<2;j++)
		{
		System.out.print(c[i][j]+"\t");
		}
		System.out.println();
		}
	}

}
