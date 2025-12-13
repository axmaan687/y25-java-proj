package com.armaan;

public class StaticBlockDemo {

		void display()
		{
			System.out.println("It is instance method 1");
		}

		static
		{
			System.out.println("It is static block 1");
		}
		public static void main(String[] args)
		{
			System.out.println("It is static method 1");
			StaticBlockDemo s1 = new StaticBlockDemo();
			s1.display();
			s1.display2();
			StaticBlockDemo.display3();
		}
		void display2()
		{
			System.out.println("It is instance method 2");
		}

		static
		{
			System.out.println("It is static block 2");
		}
		static void display3()
		{
			System.out.println("IT is static method 2");	
		}
	}


