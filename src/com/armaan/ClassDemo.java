package com.armaan;
class Person
{
	String name;
	int age;
	String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
public class ClassDemo 
{
	public static void main(String[] args) 
	{
		Person ramu = new Person();
		ramu.setName("Surneet");
		ramu.setAge(18);
		ramu.setGender("Female");
		System.out.println("Name of the person is: " +ramu.getName());
		System.out.println("Age of the person is: " +ramu.getAge());
		System.out.println("Gender of the person is: " +ramu.getGender());
	}

}
