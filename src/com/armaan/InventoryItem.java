package com.armaan;
import java.util.Scanner;

class InventoryItem {
    private String name;
    private double price;
    private int quantity;
    public InventoryItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public double totalValue() {
        return price * quantity;
    }
    public void display() {
        System.out.println("Item: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Value: $" + totalValue());
    }
}
public class InventoryTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter item name: ");
        String name = sc.nextLine();
        System.out.print("Enter item price: ");
        double price = sc.nextDouble();
        System.out.print("Enter item quantity: ");
        int quantity = sc.nextInt();

        InventoryItem item = new InventoryItem(name, price, quantity);
        item.display();

        sc.close();
    }
}
