package com.armaan;
class Emp1 implements Cloneable
{
	void display()
	{
		System.out.println("Cloning of Object Creation");
	}
	Object myClone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}
public class ObjectClonableImplementation 
{

	public static void main(String[] args) throws CloneNotSupportedException 
	{
		Emp1 e1 = new Emp1();
		e1.display();
		Emp1 e2 = (Emp1)e1.myClone();
		e2.display();
	}

}
