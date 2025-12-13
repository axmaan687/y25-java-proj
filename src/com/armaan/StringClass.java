package com.armaan;

public class StringClass 
{
	public static void main(String[] args) 
	{
		String s1 = "Ramya";
		String s2 = "Krishna";
		char ch[] = {'r','a','j','u'};
		String s3 = new String(ch);
		String s4 = new String("Balu");
		System.out.println("First String is:" +s1);
		System.out.println("Second String is:" +s2);
		System.out.println("Third String is:" +s3);
		System.out.println("Fourth String is:" +s4);
		System.out.println("Concatnation of strings:" +s1.concat(s2));
		System.out.println("Substring of strings:" +s2.substring(0,3));
		if(s1.equals(s2))
		{
			System.out.println("Two Strings are equal:");
		}
		else
		{
			System.out.println("Two Strings are not equal:");
		}
		if(s1.compareTo(s2)==0)
		{
			System.out.println("Two Strings are equal:");
		}
		else if(s1.compareTo(s2)>0)
		{
			System.out.println("s1 is bigger than s2");
		}
		else
		{
			System.out.println("s1 is smaller than s2");
		}
		System.out.println("Index of Strings" +s1.indexOf("a"));
		System.out.println("Index of Strings" +s1.lastIndexOf("a"));
		System.out.println("String Uppercase:" +s1.toLowerCase());
		System.out.println("To Uppercase:" +s1.toUpperCase());
		System.out.println("Length of the string is:" +s1.length());
		System.out.println("Substring of Strings:" +s2.substring(1));
		}
}
