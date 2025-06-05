package org.example.models;

import java.util.*;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("0 (exit), 1 (add), or 2 (remove):");
        int input = scanner.nextInt();
        scanner.nextLine();

        if (!(input == 0 || input == 1 || input == 2)) {
            System.out.println("Enter a valid number: 0, 1, or 2!");
            return;
        }

        if (input == 0) {
            System.out.println("Application stopped.");
        } else if (input == 1) {
            System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
            String inputGrocery = scanner.nextLine();
            addItems(inputGrocery);
            printSorted();
        } else if (input == 2) {
            System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
            String inputGrocery = scanner.nextLine();
            removeItems(inputGrocery);
            printSorted();
        }

        scanner.close();
    }

    public static void addItems(String product) {
        if (product.contains(",")) {
            String[] productArray = product.split(",");
            //ArrayList<String> productsToAdd = new ArrayList<>();
            for (String item : productArray) {
                String trimmed = item.trim();
                if (checkItemIsInList(trimmed)) {
                    System.out.println(trimmed + " zaten listede.");
                } else {
                    groceryList.add(trimmed);
                }
            }

        } else {
            String trimmed = product.trim();
            if (checkItemIsInList(trimmed)) {
                System.out.println("Ürün listede bulunmaktadır.");
            } else {
                groceryList.add(trimmed);

            }
        }
    Collections.sort(groceryList);
    }

    public static void removeItems(String product) {
    if (product.contains(",")) {
        String[] productArray = product.split(",");
        for (String item: productArray) {
            if (checkItemIsInList(item.trim())) {groceryList.remove(item.trim());Collections.sort(groceryList);}
            else {System.out.println(item.trim() +" zaten listede bulunmamaktadır.");}
        }
    }
    else {
        if (checkItemIsInList(product.trim())) {groceryList.remove(product.trim());Collections.sort(groceryList);}
        else {System.out.println(product.trim()+" zaten listede bulunmamaktadır.");}
    }
    Collections.sort(groceryList);
    }



    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Sorted Grocery List: " + groceryList);
    }
}
