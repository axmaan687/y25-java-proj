package com.armaan;
import java.util.Scanner;
public class matrixmultiplication
{
	public static void main(String[] args) 
	{
		int r1,c1,r2,c2;
		Scanner s1=new Scanner(System.in);
		System.out.println("enter no of rows in first array:");
		r1=s1.nextInt();
		System.out.println("enter no of columns in first array:");
		c1=s1.nextInt();
		int a[][]=new int[r1][c1];
		System.out.println("Enter First Array elements are:");
		for(int i=0;i<r1;i++)
		{
			for(int j=0;j<c1;j++)
			{
				System.out.println("enter a["+i+"]["+j+"] element:");
				a[i][j]=s1.nextInt();
			}
		}
		System.out.println("First Array elements are:");
		for(int i=0;i<r1;i++)
		{
			for(int j=0;j<c1;j++)
			{
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("enter no of rows in Second array:");
		r2=s1.nextInt();
		System.out.println("enter no of columns in Second array:");
		c2=s1.nextInt();
		int b[][]=new int[r2][c2];
		System.out.println("Enter Second Array elements are:");
		for(int i=0;i<r2;i++)
		{
			for(int j=0;j<c2;j++)
			{
				System.out.println("enter b["+i+"]["+j+"] element:");
				b[i][j]=s1.nextInt();
			}
		}
		System.out.println(" second  Array elements are:");
		for(int i=0;i<r2;i++)
		{
			for(int j=0;j<c2;j++)
			{
				System.out.print(b[i][j]+"\t");
			}
			System.out.println();
		}
		if(c1!=r2)
		{
			System.out.println("Matrix multiplication is not possible");
			System.exit(0);
		}
		else
		{
			int c[][]=new int[r1][c2];
			for(int i=0;i<r1;i++)
			{
				
				for(int j=0;j<c2;j++)
				{
					c[i][j]=0;
					for(int k=0;k<r2;k++)
					{
						c[i][j]+=a[i][k]*b[k][j];
					}
					
				}
			}
			System.out.println("Result Matrix elements are:");
			for(int i=0;i<r1;i++)
			{
				for(int j=0;j<c2;j++)
				{
					System.out.print(c[i][j]+"\t");
				}
				System.out.println();
			}
			
		}


	}

}
