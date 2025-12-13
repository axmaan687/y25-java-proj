package com.armaan;

import java.util.Scanner;

class SampleCall
{
	int num1,num2;
	/*void swap(int num1, int num2)
	{
	int temp;
	temp = num1;
	num1 = num2;
	num2 = temp;
	}*/
	void swap2()
	{
		
	}
}
public class CallByValue 
{

	public static void main(String[] args) 
	{
		SampleCall o1 = new SampleCall();
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter the First Number:");
		o1.num1 = s1.nextInt();
		System.out.println("Enter the Second Number:");
		o1.num2 = s1.nextInt();
		System.out.println("Before Swap:");
		System.out.println("num1 = "+o1.num1+"\t"+"num2 = "+o1.num2);
		o1.swap2();
		
		System.out.println("After Swap:");
		System.out.println("num1 = "+num1+"\t"+"num2 = "+num2);
	}

}
