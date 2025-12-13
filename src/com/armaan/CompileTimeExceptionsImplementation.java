package com.armaan;
import java.io.DataInputStream;
import java.io.IOException;
public class CompileTimeExceptionsImplementation 
{
	public static void main(String[] args)throws IOException
	{
		DataInputStream dis = new DataInputStream(System.in);
		System.out.println("Enter your name: ");
		String s2 = dis.readLine();
		System.out.println("Entered Name is = " +s2);
	}
}
