package com.armaan;
class A
{
	void display()
	{
		System.out.println("It is Final Method");
	}
}
class B extends A
{
	void display2()
	{
		System.out.println("It is not Final Method");
	}
}
public class FinalKeywordImplementation 
{

	public static void main(String[] args) 
	{
		B b1 = new B();
		b1.display();
		b1.display2();
	}

}
