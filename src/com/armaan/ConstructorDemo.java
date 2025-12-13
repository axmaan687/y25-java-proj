package com.armaan;

class Employee
{
	String name = "Ramu";
	int age = 27;
	double sal = 10000.56;
	//default constructor
	Employee()
	{
		System.out.println("This is default constructor");
		System.out.println("Name is: " +this.name);
		System.out.println("Age is: " +this.age);
		System.out.println("Salary is: " +sal);
	}
	Employee(String name, int age, double salary)
	{
		//left side is instance variable and the right is parameterized variable
	this.name = name;
	this.age = age;
	salary = sal;
	System.out.println("Name is: " +this.name);
	System.out.println("Age is: " +this.age);
	System.out.println("Salary is: " +sal);
	this.display();
	}
	void display()
	{
		System.out.println("Name is: " +this.name);
		System.out.println("Age is: " +this.age);
		System.out.println("Salary is: " +sal);
	}
}
public class ConstructorDemo 
{
	public static void main(String[] args) 
	{
		Employee e1 = new Employee();
		Employee e2 = new Employee("Hi",10,500000);
	}

}
