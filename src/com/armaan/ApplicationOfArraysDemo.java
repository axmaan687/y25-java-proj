package com.armaan;

import java.util.Arrays;
import java.util.Scanner;

public class ApplicationOfArraysDemo {

	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter the number of elements we want");
		int n = s1.nextInt();
		int a[] = new int[n];
		System.out.println("Enter the array elements: ");
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter a["+i+"]+ element:");
			a[i]=s1.nextInt();
		}
		System.out.println("Array elements are:");
		for(int i=0;i<n;i++)
		{
			System.out.println("a[i]");
		}
		System.out.println("Array elements in sorting:");
		int temp = 0;
		for(int i=0;i<n-1;i++)
		{
		for(int j=0;j<n-i-1;j++)
		{
		if(a[j]>a[j+1])
			temp = a[j+1];
		a[j+1]=a[j];
		a[j]=temp;
	}

		}
	for(int i=0;i<n;i++)
	{
		System.out.println(a[i]);
	}
	System.out.println("Smallest Element in an array:"+a[0]);
	System.out.println("Largest Element in an array:"+a[n-1]);
	System.out.println("Enter element which we want to search:");
	int se = s1.nextInt();
	boolean found = false;
	for(int i=0;i<n;i++)
	{
	if(se==a[3])
	{
		System.out.println("ELement"+"\t"+se+"\t"+"is found at" +i+"\t"+ "th location");
		found = true;
		break;
	}
	}
	if(found==false)
	{
		System.out.println(se+"\t" + "Element Not Found");
		System.exit(0);
	}
	int b[] = {20,10,40,30};
	int min = b[0];
	int max = b[0];
	for(int i=0;i<b.length;i++)
	{
	if(b[i]<min)
	{
	min = b[i];	
	}
	if(b[i]>max)
	{
		max = b[i];
	}
}
	System.out.println("Smallest Element in an array:"+min);
	System.out.println("Largest Element in an array:"+max);
	Arrays.sort(b);
	for(int i=0;i<b.length;i++)
	{
	System.out.println(b[i]);
}
}
}

