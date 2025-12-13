package com.armaan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Represents a geographical point or a hub in the logistics network.
 */
class Location {
    private final String name;

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

/**
 * Represents the transport units (e.g., trucks, ships).
 */
 class Vehicle {
    private final String vehicleId;
    private final int capacityKg; // Maximum payload capacity
    private final String model; // Set to final for immutability
    private Location currentLocation;
    private VehicleStatus status;

    public enum VehicleStatus {
        AVAILABLE,
        EN_ROUTE,
        MAINTENANCE
    }

    public Vehicle(String model, int capacityKg, Location initialLocation) {
        // --- Input Validation Added ---
        if (capacityKg <= 0) {
            throw new IllegalArgumentException("Vehicle capacity must be a positive value.");
        }
        
        this.vehicleId = UUID.randomUUID().toString().substring(0, 8);
        this.model = model;
        this.capacityKg = capacityKg;
        this.currentLocation = initialLocation;
        this.status = VehicleStatus.AVAILABLE;
    }

    // Getters and Setters
    public String getVehicleId() { return vehicleId; }
    public int getCapacityKg() { return capacityKg; }
    public String getModel() { return model; } // Added getter for the now-final model
    public Location getCurrentLocation() { return currentLocation; }
    public VehicleStatus getStatus() { return status; }

    public void setStatus(VehicleStatus status) { this.status = status; }
    public void setCurrentLocation(Location newLocation) { this.currentLocation = newLocation; }

    @Override
    public String toString() {
        return String.format("Vehicle [ID: %s, Model: %s, Capacity: %d kg, Location: %s, Status: %s]",
                vehicleId, model, capacityKg, currentLocation.getName(), status);
    }
}

/**
 * Represents the goods or cargo that needs to be transported.
 */
class Shipment {
    private final String shipmentId;
    private final int weightKg; // Weight of the cargo
    private final Location origin;
    private final Location destination;
    private ShipmentStatus status;

    public enum ShipmentStatus {
        PENDING,
        SCHEDULED, // Used for internal staging, though IN_TRANSIT is used immediately on dispatch.
        IN_TRANSIT,
        DELIVERED
    }

    public Shipment(int weightKg, Location origin, Location destination) {
        this.shipmentId = UUID.randomUUID().toString().substring(0, 8);
        this.weightKg = weightKg;
        this.origin = origin;
        this.destination = destination;
        this.status = ShipmentStatus.PENDING;
    }

    // Getters and Setters
    public String getShipmentId() { return shipmentId; }
    public int getWeightKg() { return weightKg; }
    public Location getOrigin() { return origin; }
    public Location getDestination() { return destination; }
    public ShipmentStatus getStatus() { return status; }

    public void setStatus(ShipmentStatus status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("Shipment [ID: %s, Weight: %d kg, From: %s, To: %s, Status: %s]",
                shipmentId, weightKg, origin.getName(), destination.getName(), status);
    }
}

/**
 * The core system manager responsible for tracking assets and scheduling shipments.
 * This class contains the main logic for matching shipments to vehicles.
 */
class LogisticsManager {
    private final List<Vehicle> vehicles;
    private final List<Shipment> shipments;
    // Map to track which shipment is currently loaded onto which vehicle (Vehicle ID -> Shipment Object)
    private final Map<String, Shipment> vehicleLoadMap;

    public LogisticsManager() {
        this.vehicles = new ArrayList<>();
        this.shipments = new ArrayList<>();
        this.vehicleLoadMap = new HashMap<>(); // Initialize the tracking map
    }

    /**
     * Adds a new vehicle to the logistics fleet.
     * @param vehicle The vehicle object to add.
     */
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("-> Vehicle added: " + vehicle.getVehicleId());
    }

    /**
     * Registers a new shipment request.
     * @param shipment The shipment object to register.
     */
    public void createShipment(Shipment shipment) {
        shipments.add(shipment);
        System.out.println("-> Shipment created: " + shipment.getShipmentId());
    }

    /**
     * Finds the shortest path and estimated time between two locations (stub for simplicity).
     * In a real system, this would involve complex route optimization algorithms.
     * @param start The starting location.
     * @param end The ending location.
     * @return The estimated duration in minutes.
     */
    public long calculateRouteDuration(Location start, Location end) {
        // Simple mock calculation: longer name difference means longer duration
        int distanceFactor = Math.abs(start.getName().length() - end.getName().length()) + 50;
        return distanceFactor * 10; // returns duration in minutes
    }

    /**
     * Attempts to find an appropriate available vehicle and schedule the shipment.
     * @param shipmentId The ID of the shipment to schedule.
     * @return true if scheduled successfully, false otherwise.
     */
    public boolean scheduleShipment(String shipmentId) {
        Shipment targetShipment = shipments.stream()
                .filter(s -> s.getShipmentId().equals(shipmentId))
                .findFirst()
                .orElse(null);

        if (targetShipment == null || targetShipment.getStatus() != Shipment.ShipmentStatus.PENDING) {
            System.out.println("   [FAIL] Shipment not found or already scheduled/in transit.");
            return false;
        }

        // 1. Find a suitable, available vehicle
        Vehicle assignedVehicle = vehicles.stream()
                .filter(v -> v.getStatus() == Vehicle.VehicleStatus.AVAILABLE)
                .filter(v -> v.getCapacityKg() >= targetShipment.getWeightKg())
                .filter(v -> v.getCurrentLocation().equals(targetShipment.getOrigin()))
                .findFirst()
                .orElse(null);

        if (assignedVehicle == null) {
            System.out.println("   [FAIL] No available vehicle found at " + targetShipment.getOrigin() + " with enough capacity (" + targetShipment.getWeightKg() + " kg).");
            return false;
        }

        // 2. Perform the scheduling and update statuses
        long duration = calculateRouteDuration(targetShipment.getOrigin(), targetShipment.getDestination());
        String eta = String.format("%d hours and %d minutes",
                TimeUnit.MINUTES.toHours(duration),
                duration % 60);

        // Update statuses and register the load
        assignedVehicle.setStatus(Vehicle.VehicleStatus.EN_ROUTE);
        targetShipment.setStatus(Shipment.ShipmentStatus.IN_TRANSIT);
        vehicleLoadMap.put(assignedVehicle.getVehicleId(), targetShipment); // Track the load

        System.out.println("\n--- SCHEDULING SUCCESS ---");
        System.out.println("   Shipment: " + targetShipment.getShipmentId() + " (" + targetShipment.getWeightKg() + " kg)");
        System.out.println("   Vehicle: " + assignedVehicle.getVehicleId() + " (" + assignedVehicle.getModel() + ")");
        System.out.println("   Route: " + targetShipment.getOrigin() + " -> " + targetShipment.getDestination());
        System.out.println("   Estimated Time of Arrival (ETA): " + eta);
        System.out.println("--------------------------");
        return true;
    }

    /**
     * Simulates the completion of a trip.
     * @param vehicleId The ID of the vehicle completing the route.
     * @param destination The final destination.
     */
    public void completeTrip(String vehicleId, Location destination) {
        Vehicle vehicle = vehicles.stream()
                .filter(v -> v.getVehicleId().equals(vehicleId))
                .findFirst()
                .orElse(null);

        if (vehicle == null) {
            System.out.println("   [ERROR] Vehicle ID " + vehicleId + " not recognized for trip completion.");
            return;
        }

        // Use the tracking map to find the associated shipment
        Shipment completedShipment = vehicleLoadMap.get(vehicleId);

        if (completedShipment != null && completedShipment.getDestination().equals(destination)) {
            // Confirm the delivery destination matches the intended shipment destination
            completedShipment.setStatus(Shipment.ShipmentStatus.DELIVERED);
            System.out.println("\n-> Shipment " + completedShipment.getShipmentId() + " delivered successfully to " + destination.getName() + ".");

            // Clear the load map entry
            vehicleLoadMap.remove(vehicleId);
        } else if (completedShipment != null) {
             System.out.println("\n-> Vehicle " + vehicleId + " arrived at " + destination.getName() + ", but the destination does not match the expected shipment destination (" + completedShipment.getDestination().getName() + "). Delivery status unchanged.");
        } else {
            // This case handles a vehicle moving without a tracked shipment (e.g., repositioning)
            System.out.println("\n-> Vehicle " + vehicleId + " completed a repositioning trip to " + destination.getName() + ".");
        }

        // Update vehicle location and status
        vehicle.setCurrentLocation(destination);
        vehicle.setStatus(Vehicle.VehicleStatus.AVAILABLE);
        System.out.println("-> Vehicle " + vehicle.getVehicleId() + " is now AVAILABLE at " + destination.getName() + ".");
    }

    /**
     * Displays the current status of the entire fleet and all shipments.
     */
    public void displaySystemStatus() {
        System.out.println("\n===================================");
        System.out.println("         SYSTEM STATUS REPORT");
        System.out.println("===================================");

        System.out.println("\n--- FLEET STATUS ---");
        long available = vehicles.stream().filter(v -> v.getStatus() == Vehicle.VehicleStatus.AVAILABLE).count();
        long enRoute = vehicles.stream().filter(v -> v.getStatus() == Vehicle.VehicleStatus.EN_ROUTE).count();
        System.out.printf("Total Vehicles: %d (Available: %d, En Route: %d)%n", vehicles.size(), available, enRoute);

        vehicles.forEach(System.out::println);

        System.out.println("\n--- SHIPMENTS STATUS ---");
        long delivered = shipments.stream().filter(s -> s.getStatus() == Shipment.ShipmentStatus.DELIVERED).count();
        long pending = shipments.stream().filter(s -> s.getStatus() == Shipment.ShipmentStatus.PENDING).count();
        long inTransit = shipments.stream().filter(s -> s.getStatus() == Shipment.ShipmentStatus.IN_TRANSIT).count();
        System.out.printf("Total Shipments: %d (Pending: %d, In Transit: %d, Delivered: %d)%n", shipments.size(), pending, inTransit, delivered);

        shipments.forEach(System.out::println);
        System.out.println("===================================\n");
    }
}

/**
 * Main class to initialize and run the Transport Logistics System demo.
 */
public class TransportLogisticsSystem {
    public static void main(String[] args) {
        System.out.println("Starting Transport Logistics System Simulation...");
        // [Image of a supply chain logistics flow diagram]

        // Initialize the Manager
        LogisticsManager manager = new LogisticsManager();

        // 1. Define Locations (Hubs/Warehouses)
        Location nyc = new Location("New York");
        Location la = new Location("Los Angeles");
        Location chi = new Location("Chicago");

        // 2. Add Vehicles (Fleet)
        // This vehicle will fail at runtime if the validation is uncommented
        // Vehicle truckInvalid = new Vehicle("Bad Truck", 0, nyc); 
        Vehicle truckA = new Vehicle("Heavy Hauler", 20000, nyc);
        Vehicle truckB = new Vehicle("Medium Truck", 10000, la);
        Vehicle truckC = new Vehicle("Light Van", 3000, nyc);

        manager.addVehicle(truckA);
        manager.addVehicle(truckB);
        manager.addVehicle(truckC);
        System.out.println("\n--- FLEET INITIALIZED ---");

        // 3. Create Shipments (Demand)
        Shipment s1 = new Shipment(15000, nyc, la); // Heavy load, NYC to LA
        Shipment s2 = new Shipment(8000, la, chi);  // Medium load, LA to Chicago
        Shipment s3 = new Shipment(4000, nyc, chi);  // Medium load, NYC to Chicago (will fail: TruckC is too small, TruckA is en route)
        Shipment s4 = new Shipment(1000, la, nyc); // Small load, LA to NYC

        manager.createShipment(s1);
        manager.createShipment(s2);
        manager.createShipment(s3);
        manager.createShipment(s4);
        System.out.println("\n--- SHIPMENTS REGISTERED ---");

        // 4. Schedule Shipments
        System.out.println("\n===================================");
        System.out.println("       ATTEMPTING SCHEDULING");
        System.out.println("===================================");

        // Schedule S1 (Heavy load: requires Truck A at NYC)
        manager.scheduleShipment(s1.getShipmentId());

        // Schedule S2 (Medium load: requires Truck B at LA)
        manager.scheduleShipment(s2.getShipmentId());

        // Schedule S3 (Will fail because TruckC (3000kg) is too small, and TruckA is now EN_ROUTE)
        System.out.println("\nAttempting to schedule S3...");
        manager.scheduleShipment(s3.getShipmentId());

        // 5. System Status Check after Scheduling
        manager.displaySystemStatus();

        // 6. Simulate Trip Completion
        System.out.println("\n===================================");
        System.out.println("    SIMULATING TRIP COMPLETION");
        System.out.println("===================================");
        // Truck A (Heavy Hauler) completes its trip (NYC -> LA)
        // This will correctly update S1 to DELIVERED and make TruckA AVAILABLE at LA
        manager.completeTrip(truckA.getVehicleId(), la);

        // Now Truck A is AVAILABLE at LA
        manager.displaySystemStatus();

        // 7. Re-attempt to Schedule S4 (Small load, LA to NYC)
        System.out.println("\nAttempting to schedule S4 using newly available Truck A...");
        // Truck A is now at LA, has enough capacity, and is available.
        manager.scheduleShipment(s4.getShipmentId());

        manager.displaySystemStatus();
    }
}