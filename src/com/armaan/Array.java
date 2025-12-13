package com.armaan;

import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		int a[]= {10,20,30,40,50};
		//array elements without loops
		System.out.println("array elements are:");
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		System.out.println(a[3]);
		System.out.println(a[4]);
		System.out.println("array elements are with loops");
		for(int i=0;i<a.length;i++)
		{
		System.out.println(a[i]);
		}
		//array creation new operator
		int[] b=new int[] {10,20,30,40,50};
		//array elements using  loops
		for( int i=0;i<b.length;i++) {
			System.out.println(b[i]);
		}
		int c[]=new int[5];
		c[0]=5;
		c[1]=15;
		System.out.println("array elemets are with loops");
		for( int i=0;i<c.length;i++) {
			System.out.println(c[i]);
			
			
		}
		//accessing of array elements using array loops
		System.out.println("accesing of array elemnts using arraay loops");
		for(int x:a) {
			System.out.println(x);
			
		}
		//read an array element from kb
		System.out.println("enter size of an array");
		Scanner s1=new Scanner(System.in);
		int n = s1.nextInt();
		System.out.println("Enter Array Elements:");
		for(int i=0;i<n;i++)
		{
		System.out.println("Enter" + "\t" + (i+1) + "element:" +a[i]);
		a[i] = s1.nextInt();
		}
		System.out.println("Array elements are:");
		for(int i=0;i<n;i++)
		{
			System.out.println(a[i]);
		}
		System.out.println("end of loop");
	}  
}