package com.armaan;
import java.util.HashSet;
public class HashSetImplementation
{
	public static void main(String[] args) 
	{
		HashSet<Integer> h1 = new HashSet<Integer>();
		h1.add(10);
		h1.add(20);
		h1.add(30);
		h1.add(10);
		System.out.println("Collection elements are:" +h1);
		System.out.println("Collection object is empty:" +h1.isEmpty());
		System.out.println("Check element is available or not:" +h1.contains(20));
		System.out.println("Check element is available or not:" +h1.contains(200));
		h1.remove(20);
		Iterator i1 = h1.iterator();
		}

}
