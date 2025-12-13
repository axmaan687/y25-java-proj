package com.armaan;
import java.util.Vector;
public class VectorImple 
{

	public static void main(String[] args)
	{
		Vector<String> v1 = new Vector<String>();
		v1.add("Ramu");
		v1.add("Balu");
		v1.add("Anu");
		v1.add(null);
		v1.add(2,"Mahi");
		v1.add(null);
		v1.add(1,"Raju");
		System.out.println("Object Elements are :" + v1);
		v1.set(2, "Balaya");
		System.out.println("Object Elements are :" + v1);
		System.out.println("Get Element :" + v1.get(2));
		v1.remove(2);
		System.out.println("Remove Element :" + v1.get(2));
		System.out.println("Object Elements are :" + v1);
	}

}
