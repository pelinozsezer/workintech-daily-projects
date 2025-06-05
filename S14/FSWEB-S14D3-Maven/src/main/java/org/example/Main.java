package org.example;


import org.example.arge.CarSkeleton;
import org.example.arge.ElectricCar;
import org.example.arge.GasPoweredCar;
import org.example.arge.HybridCar;

public class Main {
    public static void main(String[] args) {
        // Polymorphic object creation
        CarSkeleton electricCar = new ElectricCar("Tesla Model S", "Fully electric sedan", 450.0, 100);
        CarSkeleton hybridCar = new HybridCar("Toyota Prius", "Hybrid hatchback", 25.0, 80, 4);
        CarSkeleton gasCar = new GasPoweredCar("Ford Mustang", "Gasoline-powered muscle car", 12.0, 8);

        // Common interface, dynamic method dispatch
        electricCar.startEngine();
        electricCar.drive();

        hybridCar.startEngine();
        hybridCar.drive();

        gasCar.startEngine();
        gasCar.drive();
    }

}