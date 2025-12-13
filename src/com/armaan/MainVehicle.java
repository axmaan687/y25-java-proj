package com.armaan;
abstract class Vehicle {
 String name;
 Vehicle(String name) {
     this.name = name;
 }
 abstract double getMaxSpeed();
 abstract double getMileage();
 abstract double getCost();
 void showInfo() {
     System.out.println("Vehicle: " + name);
     System.out.println("Max Speed: " + getMaxSpeed() + " km/h");
     System.out.println("Mileage: " + getMileage() + " km/l");
     System.out.println("Cost: Rs. " + getCost());
     System.out.println("-------------------------------");
 }
}
class Car extends Vehicle {
 Car(String name) {
     super(name);
 }
 double getMaxSpeed() { return 180; }
 double getMileage() { return 15; }
 double getCost() { return 800000; }
}
class Bike extends Vehicle {
 Bike(String name) {
     super(name);
 }
 double getMaxSpeed() { return 120; }
 double getMileage() { return 40; }
 double getCost() { return 60000; }
}
class Truck extends Vehicle {
 Truck(String name) {
     super(name);
 }
 double getMaxSpeed() { return 110; }
 double getMileage() { return 8; }
 double getCost() { return 1500000; }
}
public class MainVehicle {
 public static void main(String[] args) {
     Vehicle v1 = new Car("Sedan");
     Vehicle v2 = new Bike("Sport Bike");
     Vehicle v3 = new Truck("Cargo Truck");
     v1.showInfo();
     v2.showInfo();
     v3.showInfo();
 }
}
