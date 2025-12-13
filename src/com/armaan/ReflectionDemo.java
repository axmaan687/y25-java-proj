package com.armaan;
import java.lang.reflect.*;

class Sample {
    private int x;
    public String msg;

    public Sample() {}
    public Sample(int x) { this.x = x; }

    public void sayHello() {
        System.out.println("Hello!");
    }
}

public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("Sample");

            System.out.println("Class Name: " + cls.getName());

            System.out.println("\nConstructors:");
            for (Constructor<?> c : cls.getDeclaredConstructors())
                System.out.println(" " + c);

            System.out.println("\nMethods:");
            for (Method m : cls.getDeclaredMethods())
                System.out.println(" " + m);

            System.out.println("\nFields:");
            for (Field f : cls.getDeclaredFields())
                System.out.println(" " + f);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
