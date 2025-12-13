package com.armaan;

import java.util.Scanner;

public class ControlStatementsDemo {

	public static void main(String[] args) {
		int a,b;
		String name;
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter your name:");
		name=s1.nextLine();
System.out.println("Enter a value:");
a=s1.nextInt();
System.out.println("Enter b value:");
b=s1.nextInt();
System.out.println("First number is="+a);
System.out.println("Second number="+b);
System.out.println("Entered name is:"+name);
if(a<b) {
	System.out.println(a+ "b is smaller than" +b);
}
else 
	System.out.println(b+ " is smaller than" + a);
if(a>0) {
	System.out.println(a+ "is positive"); }
else {
	System.out.println("a is negative"); }
if(a==1)
{
	System.out.println("Day is Monday");
}
else if(a==2)
{System.out.println("Day is Tuesday");
	}
else if(a==3)
{
	System.out.println("Day is Wednesday");
}
else if(a==4)
{
	System.out.println("Day is Thursday");
}
else if(a==5)
{
	System.out.println("Day is Friday");
}
else if(a==6)
{
	System.out.println("Day is Saturday");
}
else if(a==7)
{
	System.out.println("Day is Sunday");
}
else {
	System.out.println("Invalid Day");
}	
}
}

