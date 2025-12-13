package com.armaan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Teacher implements Serializable
{
	private static final long serialVersionUID = 1L;
	int tid;
	String tname;
	double tsal;
	public Teacher(int tid, String tname, double tsal) 
	{
		super();
		this.tid = tid;
		this.tname = tname;
		this.tsal = tsal;
	}
	void display()
	{
		System.out.println(this.tid + "\t" + this.tname + "\t" + this.tsal);
	}
}
public class ObjectSerializationImplementation 
{
	public static void main(String[] args) 
	{
		Teacher anu = new Teacher(1234,"Anushka",10000.56);
		try
		{
			FileOutputStream fos = new FileOutputStream("minu.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(anu);
			fos.close();
			oos.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("Object stored into file");
		}
		System.out.println("Read an Object from the file");
		try
		{
			FileInputStream fis = new FileInputStream("minu.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ois.readObject();
	}
	}
}
