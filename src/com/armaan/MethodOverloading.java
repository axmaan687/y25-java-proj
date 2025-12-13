package com.armaan;
class Operation
{
	int sum()
	{
		int a = 10,b=20;
		return (a+b);
	}
	int sum(int a,int b)
	{
		return (a+b);
	}
	int sum(int a,int b,int c)
	{
		return (a+b+c);
	}
}
public class MethodOverloading 
{

	public static void main(String[] args) 
	{
	Operation o1 = new Operation();
	System.out.println("Addition:"+o1.sum());
	System.out.println("Addition:"+o1.sum(10,5));
	System.out.println("Addition:"+o1.sum(5,2,3));
	}

}
