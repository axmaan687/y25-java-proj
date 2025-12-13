package com.armaan;

public class ArithmeticoperatorDemo {

	public static void main(String[] args) {
		int a = 10,b;
		b= ++a;
		System.out.println("a="+a);
		System.out.println("b="+b);
		b = --a;
		System.out.println("a="+a);
		System.out.println("b="+b);
		b=a++;
		System.out.println("a="+a);
		System.out.println("b="+b);
		b=a--;
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("Result of + operator:"+(10+20));
		System.out.println("Result of - operator:"+(10-20));
		System.out.println("Result of * operator:"+(10*20));
		System.out.println("Result of / operator:"+(10/20));
		System.out.println("Result of % operator:"+(10%20));
		System.out.println("Result of % operator:"+(100%23));
		System.out.println("Result of % operator:"+(10%10));
	}

}
