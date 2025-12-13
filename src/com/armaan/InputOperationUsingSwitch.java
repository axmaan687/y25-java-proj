package com.armaan;

import java.util.Scanner;
public class InputOperationUsingSwitch {

	public static void main(String[] args) {
		int a,b,result;
		char ch;
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter a value:");
		a=s1.nextInt();
		System.out.println("Enter b value:");
		b=s1.nextInt();
		System.out.println("Enter operator which we need:");
		ch = s1.next().charAt(0);
		switch(ch)
		{
		case '+':
		{
			result = a + b;
			System.out.println("Result of entered operator is ="+result);
			break;
		}
		case '-':
		{
			result = a - b;
			System.out.println("Result of entered operator is ="+result);
			break;
		}
		case '*':
		{
			result = a * b;
			System.out.println("Result of entered operator is ="+result);
			break;
		}
		case '/':
		{
			result = a/b;
			System.out.println("Result of entered operator is ="+result);
			break;
		}
		case '%':
		{
			result = a % b;
			System.out.println("Result of entered operator is ="+result);
			break;
		}
		default:
			System.out.println("Invalid Operator");
			break;
		}
		System.out.println("End of my project");
		}

}
