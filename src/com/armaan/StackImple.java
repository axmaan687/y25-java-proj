package com.armaan;
import java.util.Stack;
public class StackImple
{

	public static void main(String[] args) 
	{
		Stack<Integer> s1 = new Stack<Integer>();
		s1.push(10);
		s1.push(20);
		s1.push(30);
		s1.push(10);
		s1.push(40);
		System.out.println("Elements are :" + s1);
		s1.pop();
		System.out.println("Elements are :" + s1);
		int i = s1.search(10);
		System.out.println("Elements available at :" +i);
		System.out.println(s1.peek());
	}

}
