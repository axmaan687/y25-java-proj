package com.armaan;
public class CommandLineArguments
{
	public static void main(String[] args) 
	{
		for(int i=0;i<args.length;i++)
		{
		System.out.println("First Argument is:"+args[i]);	
	}
		int n1=Integer.parseInt(args[0]);
		int n2=Integer.parseInt(args[1]);
		System.out.println("First Argument is: " +n1);
		System.out.println("Second Argument is: " +n2);
		int result = n1 + n2;
		System.out.println("Sum of arguments is: " +result);
	}
}
