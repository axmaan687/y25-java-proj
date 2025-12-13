package com.armaan;
class Garbage
{
	void display()
	{
		System.out.println("Implementation of Garbage Collector");
	}
}
public class GarbageCollectorImp1 
{

	public static void main(String[] args) 
	{
		Garbage g1 = new Garbage();
		g1.display();
		Garbage g2 = new Garbage();
		g2.display();
		g2 = null;
		System.gc();
	}

}
