package com.armaan;
//Shape2D.java
abstract class Shape2D {
 abstract double area();
}

//Shape3D.java
interface Shape3D {
 double volume();
 double surfaceArea();
}

//Circle.java
class Circle extends Shape2D {
 double radius;

 Circle(double radius) {
     this.radius = radius;
 }

 double area() {
     return Math.PI * radius * radius;
 }
}

//Cylinder.java
class Cylinder extends Circle implements Shape3D {
 double height;

 Cylinder(double radius, double height) {
     super(radius);
     this.height = height;
 }

 public double volume() {
     return area() * height;
 }

 public double surfaceArea() {
     return (2 * Math.PI * radius * height) + (2 * area());
 }
}

//MainShape.java
public class MainShape {
 public static void main(String[] args) {
     Cylinder c = new Cylinder(3, 5);

     System.out.println("Circle Area: " + c.area());
     System.out.println("Cylinder Volume: " + c.volume());
     System.out.println("Cylinder Surface Area: " + c.surfaceArea());
 }
}

