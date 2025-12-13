package com.armaan;

import java.util.Scanner;

public class staticmethod {

	public static void main(String[] args) {
		static void sum() 
		{
			int a=10,b=20,result;
			result=a+b;
			System.out.println("Result of addition:"+result);
		}
	static int sub()
	{
		int a=10,b=6,result;
		result=a-b;
		return result;
	}
	 static int mul(int x,int y)
	 {
		 int a,b,result;
		 a=x;
		 b=y;
		 result =a*b;
		 return result;
		 
	}

	public class staticmethoddemo {

		public static void main(String[] args)
		{
			Sample2.sum();
			int result=Sample2.sub();
			System.out.println("Result of subraction:"+result);
			int result1=Sample2.mul(5, 6);
			System.out.println("Result of multiplication:"+result1);
			
			

		}


	}

}
