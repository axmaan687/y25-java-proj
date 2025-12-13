package com.armaan;

class PayrollSystem {
    int empId;
    String name;
    double salary;     // Basic salary

    // Constructor
    PayrollSystem(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    // Method to calculate Net Salary
    double calculateNetSalary() {
        double hra = salary * 0.20;  // 20% HRA
        double da = salary * 0.10;   // 10% DA
        double tax = salary * 0.05;  // 5% Tax deduction

        double netSalary = salary + hra + da - tax;
        return netSalary;
    }

    // Method to display employee details
    void display() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + name);
        System.out.println("Basic Salary: " + salary);
        System.out.println("Net Salary: " + calculateNetSalary());
    }
}

public class Empl {
    public static void main(String[] args) {
        PayrollSystem e1 = new PayrollSystem(101, "Armaan", 50000);

        System.out.println("---- Employee Payroll Details ----");
        e1.display();
    }
}