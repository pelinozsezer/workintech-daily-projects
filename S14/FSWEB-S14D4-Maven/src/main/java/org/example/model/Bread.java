package org.example.model;

public class Bread extends ProductForSale{
    private boolean isBread = true;

    public Bread(String type, int price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        String str = String.format("%s %d %s %b", getType(),getPrice(),getDescription(),isBread);
        System.out.println(str);
    }
}
