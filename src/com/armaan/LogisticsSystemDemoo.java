package com.armaan;
import java.util.ArrayList;
import java.util.List;

// 1. Custom Exception Handling: Defines an application-specific error
/**
 * Custom exception thrown when a shipment's weight exceeds the allowed limit.
 * This is a checked exception, forcing the calling method (e.g., loadCargo) to handle it.
 */
class InvalidWeightException extends Exception {
    public InvalidWeightException(String message) {
        super(message);
    }
}

// 2. Interface: Defines a contract for any entity that can be routed.
/**
 * Interface defining common behaviors for routing.
 */
interface Routable {
    /**
     * Calculates the estimated cost for a given route distance.
     * @param distanceKm The distance of the route in kilometers.
     * @return The calculated cost in currency units.
     */
    double calculateRouteCost(double distanceKm);

    /**
     * Gets the current location of the entity.
     * @return The current location string.
     */
    String getCurrentLocation();
}

// 3. Base Class: Represents a generic vehicle in the logistics system.
/**
 * Abstract base class for all vehicles, implementing the Routable interface.
 * Provides common properties like ID, capacity, and location.
 */
abstract class Vehicle implements Routable {
    protected String vehicleId;
    protected int capacityKg;
    protected String currentLocation;

    public Vehicle(String vehicleId, int capacityKg, String currentLocation) {
        this.vehicleId = vehicleId;
        this.capacityKg = capacityKg;
        this.currentLocation = currentLocation;
    }

    // Abstract method: Forces subclasses to implement how they load cargo.
    // This method throws the custom checked exception.
    public abstract void loadCargo(Shipment shipment) throws InvalidWeightException;

    // Implementation of getCurrentLocation from the Routable interface
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    public String getVehicleId() {
        return vehicleId;
    }
}

// 4. Derived Class (Inheritance & Polymorphism): Represents a Truck.
/**
 * Concrete class representing a Truck, inheriting from Vehicle.
 */
class Truck extends Vehicle {
    private double currentLoadKg = 0;
    private final double FUEL_COST_PER_KM = 0.50;

    public Truck(String vehicleId, int capacityKg, String currentLocation) {
        super(vehicleId, capacityKg, currentLocation);
    }

    // Polymorphism: Overriding the loadCargo method
    @Override
    public void loadCargo(Shipment shipment) throws InvalidWeightException {
        // Exception handling logic: Check if adding the shipment exceeds total capacity
        if (currentLoadKg + shipment.getWeightKg() > capacityKg) {
            throw new InvalidWeightException("Truck " + vehicleId + " exceeded max capacity. Load attempted: " + shipment.getWeightKg() + "kg. Current load: " + currentLoadKg + "kg.");
        }
        currentLoadKg += shipment.getWeightKg();
        System.out.println("Truck " + vehicleId + " loaded shipment " + shipment.getTrackingId() + ". Current load: " + currentLoadKg + "kg.");
    }

    // Polymorphism: Overriding the Routable method (Specific cost calculation for a Truck)
    @Override
    public double calculateRouteCost(double distanceKm) {
        // Truck cost includes fuel and a fixed maintenance fee per trip.
        return (distanceKm * FUEL_COST_PER_KM) + 150.00;
    }

    @Override
    public String toString() {
        return "Truck [ID=" + vehicleId + ", Capacity=" + capacityKg + "kg, Load=" + currentLoadKg + "kg]";
    }
}

// 4. Derived Class (Inheritance & Polymorphism): Represents a Train.
/**
 * Concrete class representing a Train, inheriting from Vehicle.
 */
class Train extends Vehicle {
    private int numberOfWagons;
    private final double ELECTRICITY_COST_PER_KM = 0.10; // Lower cost per km for high volume

    public Train(String vehicleId, int capacityKg, String currentLocation, int numberOfWagons) {
        super(vehicleId, capacityKg, currentLocation);
        this.numberOfWagons = numberOfWagons;
    }

    // Polymorphism: Overriding the loadCargo method (Train handles bulk loading differently)
    @Override
    public void loadCargo(Shipment shipment) throws InvalidWeightException {
        // Train logic: Check if a single container/shipment is too heavy for the whole train's capacity
        // (A simplified check demonstrating polymorphic difference from the Truck's cumulative load check)
        if (shipment.getWeightKg() > capacityKg) {
             throw new InvalidWeightException("Train " + vehicleId + " cannot handle single shipment of " + shipment.getWeightKg() + "kg.");
        }
        System.out.println("Train " + vehicleId + " assigned large container for shipment " + shipment.getTrackingId() + ".");
    }

    // Polymorphism: Overriding the Routable method (Specific cost calculation for a Train)
    @Override
    public double calculateRouteCost(double distanceKm) {
        // Train cost is high fixed cost + low variable cost based on wagons.
        return (distanceKm * ELECTRICITY_COST_PER_KM * numberOfWagons) + 5000.00;
    }

    @Override
    public String toString() {
        return "Train [ID=" + vehicleId + ", Wagons=" + numberOfWagons + ", Capacity=" + capacityKg + "kg]";
    }
}

// 5. Shipment Class: Represents the cargo being moved.
/**
 * Represents a single item or set of items being shipped.
 */
class Shipment {
    private String trackingId;
    private double weightKg;
    private String destination;

    public Shipment(String trackingId, double weightKg, String destination) {
        this.trackingId = trackingId;
        this.weightKg = weightKg;
        this.destination = destination;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public String getDestination() {
        return destination;
    }
}

// 6. Main Application Class for Demonstration
public class LogisticsSystemDemoo {

    public static void main(String[] args) {
        System.out.println("--- Transport Logistics System Demo ---");

        // Create Vehicles (Objects)
        Truck truck1 = new Truck("T1001", 5000, "Warehouse A");
        Train train1 = new Train("TR2001", 100000, "Rail Depot B", 20);

        // Create Shipments (Objects)
        Shipment s1 = new Shipment("SHP-001", 1500, "New York");
        Shipment s2 = new Shipment("SHP-002", 3000, "Chicago");
        // This shipment causes the exception for truck1 later
        Shipment s3 = new Shipment("SHP-003", 8000, "Los Angeles"); 

        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(truck1);
        fleet.add(train1);

        System.out.println("\n--- 1. Inheritance and Vehicle Information ---");
        for (Vehicle v : fleet) {
            System.out.println(v);
        }

        // [Image of object-oriented programming inheritance and polymorphism]

        // Polymorphism and Interface Demonstration
        System.out.println("\n--- 2. Polymorphism (Cost Calculation via Routable Interface) ---");

        double distance = 1200.0; // km
        // Routable reference can point to either Truck or Train object (Polymorphism)
        Routable r1 = truck1;
        Routable r2 = train1;

        System.out.printf("Route from %s for %s (%s km): $%.2f%n",
            r1.getCurrentLocation(), truck1.getVehicleId(), distance, r1.calculateRouteCost(distance));

        System.out.printf("Route from %s for %s (%s km): $%.2f%n",
            r2.getCurrentLocation(), train1.getVehicleId(), distance, r2.calculateRouteCost(distance));


        // Exception Handling Demonstration
        System.out.println("\n--- 3. Exception Handling (Loading Cargo) ---");

        try {
            // Success case: Shipment S1 is within the 5000kg limit
            System.out.println("Attempting to load S1 (" + s1.getWeightKg() + "kg)...");
            truck1.loadCargo(s1); // Load: 1500kg

            // Success case: Shipment S2 is still within the remaining limit (1500 + 3000 = 4500kg)
            System.out.println("Attempting to load S2 (" + s2.getWeightKg() + "kg)...");
            truck1.loadCargo(s2); // Load: 4500kg

            // Failure case: Shipment S3 is too heavy for the remaining capacity (4500 + 8000 = 12500kg > 5000kg)
            System.out.println("Attempting to load S3 (" + s3.getWeightKg() + "kg)...");
            truck1.loadCargo(s3); // This line throws the InvalidWeightException

        } catch (InvalidWeightException e) {
            // Catching the custom exception
            System.err.println("!! CRITICAL ERROR: " + e.getMessage());
            System.out.println("!! Action required: Shipment must be assigned to a higher capacity vehicle.");
        } finally {
            // Code that runs regardless of exception
            System.out.println("--- Load attempt completed. ---");
        }

        // Demonstrate Train loading (no exception expected as 8000kg < 100,000kg capacity)
        try {
            System.out.println("\nAttempting to load S3 (" + s3.getWeightKg() + "kg) onto Train...");
            train1.loadCargo(s3);
        } catch (InvalidWeightException e) {
             // This catch block is necessary because loadCargo throws the exception, but we don't expect it here.
             System.err.println("!! Unexpected Error during Train loading: " + e.getMessage());
        }
    }
}