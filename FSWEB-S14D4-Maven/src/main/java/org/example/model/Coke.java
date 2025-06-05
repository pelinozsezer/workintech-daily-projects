package org.example.model;

public class Coke extends ProductForSale{
    private boolean isCoke = true;
    public Coke(String type, int price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        String str = String.format("%s %d %s %b", getType(),getPrice(),getDescription(),isCoke);
        System.out.println(str);
    }
}
