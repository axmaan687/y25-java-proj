package com.armaan;
import java.io.*;
import java.util.*;

// -------------------- Exceptions --------------------
class RouteNotFoundException extends Exception {
    public RouteNotFoundException(String msg) { super(msg); }
}
class OverCapacityException extends Exception {
    public OverCapacityException(String msg) { super(msg); }
}

// -------------------- Vehicle Hierarchy --------------------
abstract class Vehicle {
    String id;
    double mileage;
    public Vehicle(String id, double mileage) {
        this.id = id;
        this.mileage = mileage;
    }
    public String getId() { return id; }
    public double getMileage() { return mileage; }
    public abstract String getType();
}
class Truck extends Vehicle {
    public Truck(String id, double mileage) { super(id, mileage); }
    @Override public String getType() { return "Truck"; }
}
class Van extends Vehicle {
    public Van(String id, double mileage) { super(id, mileage); }
    @Override public String getType() { return "Van"; }
}

// -------------------- Route --------------------
class Route {
    String name;
    double distance;
    double rate;
    public Route(String name, double distance, double rate) {
        this.name = name;
        this.distance = distance;
        this.rate = rate;
    }
    public String getName() { return name; }
    public double getDistance() { return distance; }
    public double getRate() { return rate; }
}

// -------------------- Strategy Pattern --------------------
interface CostStrategy {
    double computeCost(Route route, Vehicle vehicle);
}
class BasicCostStrategy implements CostStrategy {
    @Override
    public double computeCost(Route route, Vehicle vehicle) {
        return (route.getDistance() * route.getRate()) / vehicle.getMileage();
    }
}

// -------------------- RoutePlanner --------------------
interface RoutePlanner {
    void plan(List<Route> routes, List<Vehicle> fleet) throws Exception;
}
class SimpleRoutePlanner implements RoutePlanner {
    private CostStrategy strategy;
    public SimpleRoutePlanner(CostStrategy strategy) { this.strategy = strategy; }

    @Override
    public void plan(List<Route> routes, List<Vehicle> fleet) throws Exception {
        if (routes.isEmpty()) throw new RouteNotFoundException("No routes available!");
        if (fleet.isEmpty()) throw new OverCapacityException("No vehicles available!");

        Vehicle v = fleet.get(0); // pick first vehicle
        Map<Route, Double> costMap = new HashMap<>();

        System.out.println("---- Route Costs ----");
        for (Route r : routes) {
            double cost = strategy.computeCost(r, v);
            costMap.put(r, cost);
            System.out.println(r.getName() + " | Distance: " + r.getDistance() +
                               " km | Rate: " + r.getRate() +
                               " | Cost: " + cost);
        }

        PriorityQueue<Map.Entry<Route, Double>> pq =
            new PriorityQueue<>(Comparator.comparingDouble(Map.Entry::getValue));
        pq.addAll(costMap.entrySet());
        Map.Entry<Route, Double> best = pq.poll();

        File file = new File("plan.txt");
        System.out.println("Saving plan.txt at: " + file.getAbsolutePath());
        try (PrintWriter out = new PrintWriter(file)) {
            out.println("Best Route: " + best.getKey().getName());
            out.println("Cost: " + best.getValue());
            out.println("Vehicle: " + v.getType());
        }

        System.out.println("Best Route: " + best.getKey().getName() +
                           " | Cost: " + best.getValue() +
                           " | Vehicle: " + v.getType());
        System.out.println("Plan generated in plan.txt");
    }
}

// -------------------- Main with Menu --------------------
public class TransportLogisticsSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Route> routes = new ArrayList<>();
        List<Vehicle> fleet = new ArrayList<>();
        RoutePlanner planner = new SimpleRoutePlanner(new BasicCostStrategy());

        while (true) {
            System.out.println("\n--- Transport Logistics Menu ---");
            System.out.println("1. Add Route");
            System.out.println("2. Add Vehicle");
            System.out.println("3. Show Routes");
            System.out.println("4. Show Fleet");
            System.out.println("5. Optimize Plan");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter route name: ");
                        String rname = sc.nextLine();
                        System.out.print("Enter distance (km): ");
                        double dist = sc.nextDouble();
                        System.out.print("Enter rate (per km): ");
                        double rate = sc.nextDouble();
                        routes.add(new Route(rname, dist, rate));
                        System.out.println("Route added.");
                        break;
                    case 2:
                        System.out.print("Enter vehicle ID: ");
                        String vid = sc.nextLine();
                        System.out.print("Enter type (Truck/Van): ");
                        String type = sc.nextLine();
                        System.out.print("Enter mileage (km/litre): ");
                        double mil = sc.nextDouble();
                        if (type.equalsIgnoreCase("Truck")) fleet.add(new Truck(vid, mil));
                        else fleet.add(new Van(vid, mil));
                        System.out.println("Vehicle added.");
                        break;
                    case 3:
                        System.out.println("---- Routes ----");
                        for (Route r : routes) {
                            System.out.println(r.getName() + " | Distance: " + r.getDistance() + " km | Rate: " + r.getRate());
                        }
                        break;
                    case 4:
                        System.out.println("---- Fleet ----");
                        for (Vehicle v : fleet) {
                            System.out.println(v.getId() + " | Type: " + v.getType() + " | Mileage: " + v.getMileage());
                        }
                        break;
                    case 5:
                        planner.plan(routes, fleet);
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}