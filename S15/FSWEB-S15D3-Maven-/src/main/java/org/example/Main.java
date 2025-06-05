package org.example;

import org.example.entity.Employee;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new LinkedList<>();

        employeeList.add(new Employee(1, "Pelin", "Ozsezer"));
        employeeList.add(new Employee(2, "Armin", "Ozsezer"));
        employeeList.add(new Employee(3, "Alina", "Karkaroff"));
        employeeList.add(new Employee(4, "Zehra", "Cetin"));
        employeeList.add(new Employee(4, "Mehmet", "Erguven"));
        employeeList.add(new Employee(1, "Pelin", "Ozsezer"));
        employeeList.add(new Employee(2, "Armin", "Ozsezer"));
        employeeList.add(new Employee(3, "Alina", "Karkaroff"));


        System.out.println("****************************");

        List<Employee> duplicates = Main.findDuplicates(employeeList);
        System.out.println(duplicates);

        System.out.println("****************************");


        Map<Integer, Employee> uniques = Main.findUniques(employeeList);
        System.out.println(uniques);

        System.out.println("****************************");

        List<Employee> cleaned = Main.removeDuplicates(employeeList);
        System.out.println(cleaned);

        System.out.println("****************************");


    }

    public static List<Employee> findDuplicates(List<Employee> employeeList) {
        Set<Employee> iterated = new HashSet<>();
        Set<Employee> duplicatesSet = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();

        for (Employee employee : employeeList) {
            if (!iterated.add(employee) && employee != null) {
                if (duplicatesSet.add(employee)) { // HashSet her seferinde farklı sıralanıyor
                    duplicates.add(employee); // LL sayesinde sıralamayı kaybetmiyoruz
                }


            }
        }
        return new LinkedList<>(duplicates);

    }

    public static Map<Integer, Employee> findUniques(List<Employee> employeeList) {
        Map<Integer, Employee> result= new HashMap<>();
        Set<Employee> iterated = new LinkedHashSet<>();


        for (Employee employee: employeeList) {
            if (employee != null) {
                iterated.add(employee);
            }
        }

        Iterator<Employee> iterator = iterated.iterator();
        Integer indexCounter = 0;
        while (iterator.hasNext()) {
            indexCounter++;
            Employee employee = iterator.next();
            result.put(indexCounter, employee );
        }

        return result;
    }


    public static List<Employee> removeDuplicates(List<Employee> employeeList) {
        List<Employee> duplicates = Main.findDuplicates(employeeList);
        //employeeList.removeIf(e->e ==null);
        //employeeList.removeAll(duplicates);
        List<Employee> cleaned = new LinkedList<>(employeeList);
        cleaned.removeIf(e -> e == null || duplicates.contains(e));

        return cleaned;
    }


}