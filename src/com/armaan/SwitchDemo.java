package com.armaan;

import java.io.DataInputStream;

public class SwitchDemo 
{
	public static void main(String[] args)throws Exception
	{
		
int a;
DataInputStream dis = new DataInputStream(System.in);
System.out.println("Enter a value");
a = Integer.parseInt(dis.readLine());
switch (a)
{
case 1: 
	{System.out.println("Day is Monday");
System.out.println("It is my favourite day");
break; }
case 2: 
	{System.out.println("Day is Tuesday");
System.out.println("It is my favourite day");
break;}
case 3: 
	{System.out.println("Day is Wednesday");
System.out.println("It is my favourite day");
break;}
case 4: 
	{System.out.println("Day is Thursday");
System.out.println("It is my favourite day");
break;}
case 5: 
	{System.out.println("Day is Friday");
System.out.println("It is my favourite day");
break;}
case 6: {
	System.out.println("Day is Saturday");
System.out.println("It is my favourite day");
break;}
case 7: {
	System.out.println("Day is Sunday");
System.out.println("It is my favourite day");
break;}
default : System.out.println("Day is Invalid");
System.out.println("It is a dummy day");
break;
}
System.out.println("It is out of switch block");
	}
	
}
