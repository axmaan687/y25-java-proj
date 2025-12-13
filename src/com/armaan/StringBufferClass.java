package com.armaan;

public class StringBufferClass 
{

	public static void main(String[] args) 
	{
		String s1 = "Problem Solving";
		String s2 = "Using Programming Java";
		StringBuffer sb1 = new StringBuffer(s1);
		StringBuilder sb2 = new StringBuilder(s2);
		System.out.println("First String:" +s1);
		System.out.println("Second String:" +s2);
		System.out.println("StringBuffer Object:" +sb1);
		System.out.println(" StringBuilder Object:" +sb2);
		System.out.println("Length of sb1:" +sb1.length());
		System.out.println("Appending of StringBuffer Object :" +sb1.append(sb2));
		System.out.println("Insertion of StringBuffer Object:" +sb1.insert(8,"through"));
		System.out.println("Reverse of StringBuffer Objects:" +sb1.reverse());
		System.out.println("Deletion of StringBuffer Objects:" +sb1.delete(3, 9));
		System.out.println(sb1.toString());
	}

}
