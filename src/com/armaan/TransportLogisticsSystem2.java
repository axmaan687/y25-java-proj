package com.armaan;
import java.util.*;



public class TransportLogisticsSystem {

    static List<Route> routes = new ArrayList<>();

    static List<Vehicle> vehicles = new ArrayList<>();

    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Transport Logistics System ===");

        

        // Add sample data automatically (no CSV needed)

        addSampleData();

        

        while(true) {

            System.out.print("\n1.View Data  2.Add Route  3.Add Vehicle    4.Exit: ");

            int choice = sc.nextInt();

            

            if(choice == 1) viewData();

            else if(choice == 2) addRoute(sc);

            else if(choice == 3) addVehicle(sc);

           

            else if(choice == 4) break;

        }

        sc.close();

    }

    

    static void addSampleData() {

        // Sample routes (no CSV file needed)

        routes.add(new Route("R1", 200.0, 100.0, "Delhi", "Mumbai"));

        routes.add(new Route("R2", 350.0, 200.0, "Mumbai", "Bangalore"));

        routes.add(new Route("R3", 80.0, 800.0, "Delhi", "Kolkata"));

        

        // Sample vehicles

        vehicles.add(new Truck("T001", 1000.0, 8.5, 95.0));

        vehicles.add(new Van("V001", 300.0, 15.0, 92.0));

        vehicles.add(new Truck("T002", 1200.0, 7.0, 98.0));

        

        System.out.println("Sample data loaded!");

    }

    

    static void viewData() {

        System.out.println("\nRoutes:");

        for(Route r : routes) {

            System.out.println(r.id + ": " + r.source + "→" + r.destination + 

                " (" + r.distance + "km, " + r.cargoAmount + "kg)");

        }

        System.out.println("\nVehicles:");

        for(Vehicle v : vehicles) {

            System.out.println(v.id + " (" + v.getType() + "): " + v.capacity + "kg");

        }

    }

    

    static void addRoute(Scanner sc) {

        System.out.print("ID: "); String id = sc.next();

        System.out.print("Distance: "); double dist = sc.nextDouble();

        System.out.print("Cargo: "); double cargo = sc.nextDouble();

        System.out.print("Source: "); String src = sc.next();

        System.out.print("Dest: "); String dest = sc.next();

        routes.add(new Route(id, dist, cargo, src, dest));

        System.out.println("Route added!");

    }

    

    static void addVehicle(Scanner sc) {

        System.out.print("Type (Truck/Van): "); String type = sc.next();

        System.out.print("ID: "); String id = sc.next();

        System.out.print("Capacity: "); double cap = sc.nextDouble();

        System.out.print("Mileage: " ); double mile = sc.nextDouble();

        System.out.print("Rate: "); double rate = sc.nextDouble();

        

        if(type.equalsIgnoreCase("Truck"))

            vehicles.add(new Truck(id, cap, mile, rate));

        else

            vehicles.add(new Van(id, cap, mile, rate));

        System.out.println("Vehicle added!");

    }

    

    

}



// Data classes (same as before)

class Route {

    String id, source, destination;

    double distance, cargoAmount;

    Route(String id, double d, double c, String s, String dest) {

        this.id = id; this.distance = d; this.cargoAmount = c;

        this.source = s; this.destination = dest;

    }

    

    @Override public Boolean equals(Object obj) {

        if(obj instanceof Route) return ((Route)obj).id.equals(id);

        return false;

    }

}



abstract class Vehicle {

    String id; double capacity, mileage, rate;

    Vehicle(String id, double c, double m, double r) {

        this.id = id; this.capacity = c; this.mileage = m; this.rate = r;

    }

    abstract String getType();

}



class Truck extends Vehicle {

    Truck(String id, double c, double m, double r) { super(id,c,m,r); }

    String getType() { return "Truck"; }

}



class Van extends Vehicle {

    Van(String id, double c, double m, double r) { super(id,c,m,r); }

    String getType() { return "Van"; }

}



class CostPair implements Comparable<CostPair> {

    double cost; Route route; Vehicle vehicle;

    CostPair(double c, Route r, Vehicle v) { 

        cost = c; route = r; vehicle = v; 

    }

    public int compareTo(CostPair other) {

        return Double.compare(cost, other.cost);

    }

}

import java.util.*;

public class TransportLogisticsSystem {
    static List<Route> routes = new ArrayList<>();
    static List<Vehicle> vehicles = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Transport Logistics System ===");
        
        // Add sample data automatically (no CSV needed)
        addSampleData();
        
        while(true) {
            System.out.print("\n1.View Data  2.Add Route  3.Add Vehicle    4.Exit: ");
            int choice = sc.nextInt();
            
            if(choice == 1) viewData();
            else if(choice == 2) addRoute(sc);
            else if(choice == 3) addVehicle(sc);
           
            else if(choice == 4) break;
        }
        sc.close();
    }
    
    static void addSampleData() {
        // Sample routes (no CSV file needed)
        routes.add(new Route("R1", 200.0, 100.0, "Delhi", "Mumbai"));
        routes.add(new Route("R2", 350.0, 200.0, "Mumbai", "Bangalore"));
        routes.add(new Route("R3", 80.0, 800.0, "Delhi", "Kolkata"));
        
        // Sample vehicles
        vehicles.add(new Truck("T001", 1000.0, 8.5, 95.0));
        vehicles.add(new Van("V001", 300.0, 15.0, 92.0));
        vehicles.add(new Truck("T002", 1200.0, 7.0, 98.0));
        
        System.out.println("Sample data loaded!");
    }
    
    static void viewData() {
        System.out.println("\nRoutes:");
        for(Route r : routes) {
            System.out.println(r.id + ": " + r.source + "→" + r.destination + 
                " (" + r.distance + "km, " + r.cargoAmount + "kg)");
        }
        System.out.println("\nVehicles:");
        for(Vehicle v : vehicles) {
            System.out.println(v.id + " (" + v.getType() + "): " + v.capacity + "kg");
        }
    }
    
    static void addRoute(Scanner sc) {
        System.out.print("ID: "); String id = sc.next();
        System.out.print("Distance: "); double dist = sc.nextDouble();
        System.out.print("Cargo: "); double cargo = sc.nextDouble();
        System.out.print("Source: "); String src = sc.next();
        System.out.print("Dest: "); String dest = sc.next();
        routes.add(new Route(id, dist, cargo, src, dest));
        System.out.println("Route added!");
    }
    
    static void addVehicle(Scanner sc) {
        System.out.print("Type (Truck/Van): "); String type = sc.next();
        System.out.print("ID: "); String id = sc.next();
        System.out.print("Capacity: "); double cap = sc.nextDouble();
        System.out.print("Mileage: " ); double mile = sc.nextDouble();
        System.out.print("Rate: "); double rate = sc.nextDouble();
        
        if(type.equalsIgnoreCase("Truck"))
            vehicles.add(new Truck(id, cap, mile, rate));
        else
            vehicles.add(new Van(id, cap, mile, rate));
        System.out.println("Vehicle added!");
    }
    
    
}

// Data classes (same as before)
class Route {
    String id, source, destination;
    double distance, cargoAmount;
    Route(String id, double d, double c, String s, String dest) {
        this.id = id; this.distance = d; this.cargoAmount = c;
        this.source = s; this.destination = dest;
    }
    
    @Override public boolean equals(Object obj) {
        if(obj instanceof Route) return ((Route)obj).id.equals(id);
        return false;
    }
}

abstract class Vehicle {
    String id; double capacity, mileage, rate;
    Vehicle(String id, double c, double m, double r) {
        this.id = id; this.capacity = c; this.mileage = m; this.rate = r;
    }
    abstract String getType();
}

class Truck extends Vehicle {
    Truck(String id, double c, double m, double r) { super(id,c,m,r); }
    String getType() { return "Truck"; }
}

class Van extends Vehicle {
    Van(String id, double c, double m, double r) { super(id,c,m,r); }
    String getType() { return "Van"; }
}

class CostPair implements Comparable<CostPair> {
    double cost; Route route; Vehicle vehicle;
    CostPair(double c, Route r, Vehicle v) { 
        cost = c; route = r; vehicle = v; 
    }
    public int compareTo(CostPair other) {
        return Double.compare(cost, other.cost);
    }
}