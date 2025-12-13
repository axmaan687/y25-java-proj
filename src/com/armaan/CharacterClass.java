package com.armaan;
import java.util.Scanner;
public class CharacterClass 
{

	public static void main(String[] args) 
	{
		System.out.println("Enter any Character:");
		Scanner s1 = new Scanner(System.in);
		char ch = s1.next().charAt(0);
		int a = 97;
		System.out.println("Entered Character is:"+Character.isLetter(ch));
		System.out.println("Entered Character is:"+Character.isDigit(ch));
		System.out.println("Entered Character is:"+Character.isWhitespace(ch));
		System.out.println("Entered Character is:"+Character.isLetterOrDigit(ch));
		System.out.println("Entered Character is:"+Character.isLowerCase(ch));
		System.out.println("Entered Character is:"+Character.isUpperCase(ch));
		System.out.println("Entered Character is:"+Character.toUpperCase(ch));
		System.out.println("Entered Character is:"+Character.toLowerCase(ch));
		System.out.println("Entered Character is:"+Character.toUpperCase(97));
		System.out.println("Entered Character is:"+Character.isSpaceChar(ch));
	}

}
