package com.armaan;
class AccessSpecifier
{
	private int a = 10;
	public int b = 20;
	protected int c = 30;
	int d = 40;
}
public class AccessSpecifierImplementation 
{
	public static void main(String[] args) 
	{
		AccessSpecifier a1 = new AccessSpecifier();
		System.out.println(a1.b);
		System.out.println(a1.c);
		System.out.println(a1.d);
	}
}
