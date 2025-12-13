package com.armaan;
import java.io.*;
import java.util.*;

// ========================= Domain: Vehicle hierarchy =========================

abstract class Vehicle {
    protected final String id;
    protected final double capacityKg;
    protected final double mileageKmPerLiter;
    protected final double rateCurrencyPerLiter;

    public Vehicle(String id, double capacityKg, double mileageKmPerLiter, double rateCurrencyPerLiter) {
        this.id = id;
        this.capacityKg = capacityKg;
        this.mileageKmPerLiter = mileageKmPerLiter;
        this.rateCurrencyPerLiter = rateCurrencyPerLiter;
    }

    public String getId() { return id; }
    public double getCapacityKg() { return capacityKg; }
    public double getMileageKmPerLiter() { return mileageKmPerLiter; }
    public double getRateCurrencyPerLiter() { return rateCurrencyPerLiter; }
    public abstract String getType();
}

class Truck extends Vehicle {
    public Truck(String id, double capacityKg, double mileageKmPerLiter, double rateCurrencyPerLiter) {
        super(id, capacityKg, mileageKmPerLiter, rateCurrencyPerLiter);
    }
    @Override public String getType() { return "Truck"; }
}

class Van extends Vehicle {
    public Van(String id, double capacityKg, double mileageKmPerLiter, double rateCurrencyPerLiter) {
        super(id, capacityKg, mileageKmPerLiter, rateCurrencyPerLiter);
    }
    @Override public String getType() { return "Van"; }
}

// ========================= Domain: Route and Legs ============================

class RouteLeg {
    private final String legId;
    private final double distanceKm;
    private final double speedKph;
    private final double requiredCapacityKg;

    public RouteLeg(String legId, double distanceKm, double speedKph, double requiredCapacityKg) {
        this.legId = legId;
        this.distanceKm = distanceKm;
        this.speedKph = speedKph;
        this.requiredCapacityKg = requiredCapacityKg;
    }

    public String getLegId() { return legId; }
    public double getDistanceKm() { return distanceKm; }
    public double getSpeedKph() { return speedKph; }
    public double getRequiredCapacityKg() { return requiredCapacityKg; }
}

class Route {
    private final String routeId;
    private final List<RouteLeg> legs = new ArrayList<>();

    public Route(String routeId) { this.routeId = routeId; }
    public String getRouteId() { return routeId; }
    public List<RouteLeg> getLegs() { return legs; }
    public void addLeg(RouteLeg leg) { legs.add(leg); }

    public double totalDistanceKm() {
        double sum = 0.0;
        for (RouteLeg l : legs) sum += l.getDistanceKm();
        return sum;
    }

    public double totalTimeHours() {
        double sum = 0.0;
        for (RouteLeg l : legs) {
            double speed = Math.max(1e-6, l.getSpeedKph());
            sum += l.getDistanceKm() / speed;
        }
        return sum;
    }

    public double maxRequiredCapacityKg() {
        double max = 0.0;
        for (RouteLeg l : legs) max = Math.max(max, l.getRequiredCapacityKg());
        return max;
    }
}

// ========================= Exceptions =======================================

class RouteNotFoundException extends Exception {
    public RouteNotFoundException(String msg) { super(msg); }
}

class OverCapacityException extends Exception {
    public OverCapacityException(String msg) { super(msg); }
}

class CsvFormatException extends Exception {
    public CsvFormatException(String msg) { super(msg); }
}

// ========================= Strategy Pattern =================================

interface CostStrategy {
    double computeCost(Route route, Vehicle vehicle) throws OverCapacityException;
    String name();
}

class FuelCostStrategy implements CostStrategy {
    @Override
    public double computeCost(Route route, Vehicle vehicle) throws OverCapacityException {
        if (vehicle.getCapacityKg() < route.maxRequiredCapacityKg()) {
            throw new OverCapacityException(
                "Vehicle capacity " + vehicle.getCapacityKg() +
                " < required " + route.maxRequiredCapacityKg());
        }
        double distance = route.totalDistanceKm();
        return (distance * vehicle.getRateCurrencyPerLiter()) / vehicle.getMileageKmPerLiter();
    }
    @Override public String name() { return "FuelCost"; }
}

class TimeCostStrategy implements CostStrategy {
    private final double costPerHour;
    public TimeCostStrategy(double costPerHour) { this.costPerHour = costPerHour; }

    @Override
    public double computeCost(Route route, Vehicle vehicle) throws OverCapacityException {
        if (vehicle.getCapacityKg() < route.maxRequiredCapacityKg()) {
            throw new OverCapacityException("Vehicle under capacity for route " + route.getRouteId());
        }
        double timeHours = route.totalTimeHours();
        return timeHours * costPerHour;
    }
    @Override public String name() { return "TimeCost"; }
}

class HybridCostStrategy implements CostStrategy {
    private final CostStrategy fuel;
    private final CostStrategy time;
    private final double alpha; // weight for fuel [0..1]

    public HybridCostStrategy(CostStrategy fuel, CostStrategy time, double alpha) {
        this.fuel = fuel;
        this.time = time;
        this.alpha = alpha;
    }

    @Override
    public double computeCost(Route route, Vehicle vehicle) throws OverCapacityException {
        double cf = fuel.computeCost(route, vehicle);
        double ct = time.computeCost(route, vehicle);
        return alpha * cf + (1.0 - alpha) * ct;
    }
    @Override public String name() { return "HybridCost"; }
}

// ========================= Planner Interface & Impl ==========================

interface RoutePlanner {
    void addRoutes(List<Route> routes);
    void addFleet(List<Vehicle> fleet);
    double calculateCost(String routeId, String vehicleId) throws RouteNotFoundException, OverCapacityException;
    Map<Route, Double> computeAllMinCosts();
    void generatePlan(String outputFilePath) throws Exception;
}

abstract class AbstractBasePlanner implements RoutePlanner {
    protected final Map<String, Route> routeById = new HashMap<>();
    protected final Map<String, Vehicle> vehicleById = new HashMap<>();
    protected final CostStrategy strategy;

    public AbstractBasePlanner(CostStrategy strategy) { this.strategy = strategy; }

    @Override
    public void addRoutes(List<Route> routes) {
        for (Route r : routes) routeById.put(r.getRouteId(), r);
    }

    @Override
    public void addFleet(List<Vehicle> fleet) {
        for (Vehicle v : fleet) vehicleById.put(v.getId(), v);
    }

    @Override
    public double calculateCost(String routeId, String vehicleId)
            throws RouteNotFoundException, OverCapacityException {
        Route r = routeById.get(routeId);
        if (r == null) throw new RouteNotFoundException("Route not found: " + routeId);
        Vehicle v = vehicleById.get(vehicleId);
        if (v == null) throw new RouteNotFoundException("Vehicle not found: " + vehicleId);
        return strategy.computeCost(r, v);
    }

    @Override
    public Map<Route, Double> computeAllMinCosts() {
        Map<Route, Double> result = new LinkedHashMap<>();
        for (Route r : routeById.values()) {
            PriorityQueue<Double> pq = new PriorityQueue<>();
            for (Vehicle v : vehicleById.values()) {
                try {
                    double c = strategy.computeCost(r, v);
                    pq.offer(c);
                } catch (OverCapacityException e) {
                    // skip vehicles that cannot serve this route
                }
            }
            result.put(r, pq.isEmpty() ? Double.POSITIVE_INFINITY : pq.peek());
        }
        return result;
    }

    @Override
    public void generatePlan(String outputFilePath) throws Exception {
        Map<Route, Double> routeCostMap = computeAllMinCosts();
        PlanWriter.writePlan(outputFilePath, routeCostMap, strategy.name());
    }
}

class FuelCostPlanner extends AbstractBasePlanner {
    public FuelCostPlanner() { super(new FuelCostStrategy()); }
}

class TimeCostPlanner extends AbstractBasePlanner {
    public TimeCostPlanner(double costPerHour) { super(new TimeCostStrategy(costPerHour)); }
}

class HybridCostPlanner extends AbstractBasePlanner {
    public HybridCostPlanner(double costPerHour, double alpha) {
        super(new HybridCostStrategy(new FuelCostStrategy(), new TimeCostStrategy(costPerHour), alpha));
    }
}

// ========================= Factory ==========================================

class PlannerFactory {
    public static RoutePlanner create(String type) {
        switch (type) {
            case "FuelCost": return new FuelCostPlanner();
            case "TimeCost": return new TimeCostPlanner(150.0); // configurable
            case "HybridCost": return new HybridCostPlanner(150.0, 0.6);
            default: throw new IllegalArgumentException("Unknown planner type: " + type);
        }
    }
}

// ========================= CSV Loader =======================================

class CsvLoader {

    public static List<Route> loadRoutes(String routesCsvPath) throws IOException, CsvFormatException {
        Map<String, Route> map = new LinkedHashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(routesCsvPath))) {
            String line; int row = 0;
            while ((line = br.readLine()) != null) {
                row++; line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                String[] parts = line.split(",");
                if (parts.length < 5) throw new CsvFormatException("routes.csv row " + row + " has <5 columns");
                String routeId = parts[0].trim();
                String legId = parts[1].trim();
                double distanceKm = Double.parseDouble(parts[2].trim());
                double speedKph = Double.parseDouble(parts[3].trim());
                double requiredCapacityKg = Double.parseDouble(parts[4].trim());

                Route route = map.computeIfAbsent(routeId, Route::new);
                route.addLeg(new RouteLeg(legId, distanceKm, speedKph, requiredCapacityKg));
            }
        }
        return new ArrayList<>(map.values());
    }

    public static List<Vehicle> loadFleet(String fleetCsvPath) throws IOException, CsvFormatException {
        List<Vehicle> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fleetCsvPath))) {
            String line; int row = 0;
            while ((line = br.readLine()) != null) {
                row++; line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                String[] parts = line.split(",");
                if (parts.length < 5) throw new CsvFormatException("fleet.csv row " + row + " has <5 columns");
                String vehicleId = parts[0].trim();
                String type = parts[1].trim();
                double capacityKg = Double.parseDouble(parts[2].trim());
                double mileageKmPerLiter = Double.parseDouble(parts[3].trim());
                double rateCurrencyPerLiter = Double.parseDouble(parts[4].trim());

                Vehicle v;
                if ("Truck".equalsIgnoreCase(type)) {
                    v = new Truck(vehicleId, capacityKg, mileageKmPerLiter, rateCurrencyPerLiter);
                } else if ("Van".equalsIgnoreCase(type)) {
                    v = new Van(vehicleId, capacityKg, mileageKmPerLiter, rateCurrencyPerLiter);
                } else {
                    throw new CsvFormatException("Unknown vehicle type '" + type + "' at row " + row);
                }
                list.add(v);
            }
        }
        return list;
    }
}

// ========================= Plan Writer ======================================

class PlanWriter {
    public static void writePlan(String path, Map<Route, Double> routeCostMap, String plannerName) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("Planner: " + plannerName);
            bw.newLine();
            bw.write("RouteId,TotalDistanceKm,TotalTimeHours,MinCost");
            bw.newLine();
            for (Map.Entry<Route, Double> e : routeCostMap.entrySet()) {
                Route r = e.getKey();
                double cost = e.getValue();
                bw.write(r.getRouteId() + "," +
                        String.format("%.2f", r.totalDistanceKm()) + "," +
                        String.format("%.2f", r.totalTimeHours()) + "," +
                        (Double.isInfinite(cost) ? "N/A" : String.format("%.2f", cost)));
                bw.newLine();
            }
        }
    }
}

// ========================= CLI ==============================================

public class TransportCLI {

    private static void printHelp() {
        System.out.println("Transport Logistics CLI");
        System.out.println("Commands:");
        System.out.println("  addRoute <routes.csv>");
        System.out.println("  addVehicle <fleet.csv>");
        System.out.println("  calculateCost <routeId> <vehicleId>");
        System.out.println("  generatePlan <plan.txt>");
        System.out.println("  setPlanner <FuelCost|TimeCost|HybridCost>");
        System.out.println("  exit");
    }

    public static void main(String[] args) {
        RoutePlanner planner = PlannerFactory.create("FuelCost");
        List<Route> routes = new ArrayList<>();
        List<Vehicle> fleet = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Starting Transport Logistics System (FuelCost planner). Type 'help'.");

        while (true) {
            System.out.print("> ");
            if (!sc.hasNextLine()) break;
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] tokens = line.split("\\s+");
            String cmd = tokens[0];

            try {
                switch (cmd) {
                    case "help":
                        printHelp();
                        break;

                    case "setPlanner":
                        if (tokens.length < 2) {
                            System.out.println("Usage: setPlanner <FuelCost|TimeCost|HybridCost>");
                            break;
                        }
                        planner = PlannerFactory.create(tokens[1]);
                        planner.addRoutes(routes);
                        planner.addFleet(fleet);
                        System.out.println("Planner set to " + tokens[1]);
                        break;

                    case "addRoute":
                        if (tokens.length < 2) {
                            System.out.println("Usage: addRoute <routes.csv>");
                            break;
                        }
                        String routesCsv = tokens[1];
                        List<Route> loadedRoutes = CsvLoader.loadRoutes(routesCsv);
                        routes.addAll(loadedRoutes);
                        planner.addRoutes(loadedRoutes);
                        System.out.println("Loaded " + loadedRoutes.size() + " routes from " + routesCsv);
                        break;

                    case "addVehicle":
                        if (tokens.length < 2) {
                            System.out.println("Usage: addVehicle <fleet.csv>");
                            break;
                        }
                        String fleetCsv = tokens[1];
                        List<Vehicle> loadedFleet = CsvLoader.loadFleet(fleetCsv);
                        fleet.addAll(loadedFleet);
                        planner.addFleet(loadedFleet);
                        System.out.println("Loaded " + loadedFleet.size() + " vehicles from " + fleetCsv);
                        break;

                    case "calculateCost":
                        if (tokens.length < 3) {
                            System.out.println("Usage: calculateCost <routeId> <vehicleId>");
                            break;
                        }
                        String routeId = tokens[1];
                        String vehicleId = tokens[2];
                        double cost = planner.calculateCost(routeId, vehicleId);
                        System.out.printf("Cost(%s, %s) = %.2f%n", routeId, vehicleId, cost);
                        break;

                    case "generatePlan":
                        if (tokens.length < 2) {
                            System.out.println("Usage: generatePlan <plan.txt>");
                            break;
                        }
                        String outputPath = tokens[1];
                        planner.generatePlan(outputPath);
                        System.out.println("Plan written to " + outputPath);
                        break;

                    case "exit":
                        System.out.println("Bye.");
                        return;

                    default:
                        System.out.println("Unknown command. Type 'help'.");
                }
            } catch (RouteNotFoundException | OverCapacityException | CsvFormatException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("IO Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Config Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            }
        }
    }
}