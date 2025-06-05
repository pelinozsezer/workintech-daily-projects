package org.example.model;

public class Store {
    public static void main(String[] args) {
        ProductForSale[] products = new ProductForSale[3];

        products[0] = new Chocolate("Bitter", 3,"chocooooo");
        products[1] = new Coke("Zero", 2,"cokeeeeee");
        products[2] = new Bread("Whole Wheat", 2,"breaddddddd");

        //listProducts();
        listProducts(products);
    }

    public static void listProducts(ProductForSale[] products) {
        for (ProductForSale product: products) {
            product.showDetails();
        }
    }
}