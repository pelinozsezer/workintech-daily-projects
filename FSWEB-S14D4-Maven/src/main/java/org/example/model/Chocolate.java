package org.example.model;

public class Chocolate extends ProductForSale{
    private boolean isChocolate = true;

    public Chocolate(String type, int price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        String str = String.format("%s %d %s %b", getType(),getPrice(),getDescription(),isChocolate);
        System.out.println(str);
    }
}
