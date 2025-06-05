package org.example;
import org.example.enums.Plan;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // Healthplan
        Healthplan healthplan = new Healthplan(101, "health plan X", Plan.BASIC);
        System.out.println(healthplan.toString());

        // Employee
        String[] healthPlansArray = new String[2];
        Employee employee = new Employee(1, "John Doe", "john@example.com", "1234", healthPlansArray);
        employee.addHealthPlan(1, healthplan.getName());
        System.out.println(employee.toString());

        // Company
        String[] devs = new String[2];
        devs[0] = "Jane";
        Company company = new Company(1, "Workintech", -500, devs);
        company.addEmployee(1, "Ali");
        System.out.println(company.toString());

        // Negatif giro
        System.out.println("Negatif girilen giro değeri aslında: " + company.getGiro());
    }
}