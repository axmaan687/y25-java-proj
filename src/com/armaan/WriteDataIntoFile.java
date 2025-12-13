package com.armaan;
import java.io.DataInputStream;
import java.io.FileOutputStream;
public class WriteDataIntoFile 
{
	public static void main(String[] args)throws Exception 
	{
		DataInputStream dis = new DataInputStream(System.in);
		System.out.println("Read Data from kb to write into file");
		char ch;
		try
		{
			FileOutputStream fos = new FileOutputStream("minu.txt",true);
			while((ch = (char)dis.read())!='@')
			{
			fos.write(ch);
			}
			fos.close();
		}
			catch (Exception e)
			{
				
			}
			finally 
			{
				System.out.println("File created with content");
			}
		dis.close();
	}

}
