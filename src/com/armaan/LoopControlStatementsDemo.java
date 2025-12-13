package com.armaan;

import java.util.Scanner;

public class LoopControlStatementsDemo 
{

	public static void main(String[] args) 
	{
int i;
Scanner s1 = new Scanner(System.in);
System.out.println("Enter i value:");
i = s1.nextInt();
/*do
{
	System.out.println("Armaan");
	i++;//i=i+1
} while(i<=10);*/
for(i=1;i<=10;i++)
{
	System.out.println("Armaan");
}
System.out.println("End of Loop");
	}

}
