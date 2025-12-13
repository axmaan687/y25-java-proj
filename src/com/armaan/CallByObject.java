package com.armaan;
import java.util.Scanner;
class SampleObject
{
	int num1, num2;
	void swap2(SampleObject obj1)
	{
		int temp;
		temp = obj1.num1;
		obj1.num1 = obj1.num2;
		obj1.num2 = temp;
	}
}
public class CallByObject 
{

	public static void main(String[] args) 
	{
		SampleObject obj1 = new SampleObject();
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter the First Number:");
		obj1.num1 = s1.nextInt();
		System.out.println("Enter the Second Number:");
		obj1.num2 = s1.nextInt();
		System.out.println("Before Swap:");
		System.out.println(obj1.num1 + "\t" + obj1.num2);
		//call method by reference
		obj1.swap2(obj1);
		System.out.println("After Swap:");
		System.out.println(obj1.num1 + "\t" + obj1.num2);
	}

}
