package org.example.models;

public class DeluxeBurger extends Hamburger{
    private String cips;
    private String drink;
    private static final double DEFAULT_PRICE = 19.10;




    public DeluxeBurger(String name, String meat, String breadRollType) {
        super(name, meat,DEFAULT_PRICE, breadRollType);

        this.cips = "CURVY";
        this.drink = "COKE";
    }

    public String getCips() {
        return cips;
    }

    public String getDrink() {
        return drink;
    }

    @Override
    public void addHamburgerAddition1(String addition1Name, double addition1Price) {
        System.out.println("Deluxe Burger için yeni malzeme eklenemez.");
    }

    @Override
    public void addHamburgerAddition2(String addition2Name, double addition2Price) {
        System.out.println("Deluxe Burger için yeni malzeme eklenemez.");
    }

    @Override
    public void addHamburgerAddition3(String addition3Name, double addition3Price) {
        System.out.println("Deluxe Burger için yeni malzeme eklenemez.");
    }

    @Override
    public void addHamburgerAddition4(String addition4Name, double addition4Price) {
        System.out.println("Deluxe Burger için yeni malzeme eklenemez.");
    }

    @Override
    public double itemizeHamburger() {
        System.out.println(String.format("%f", DEFAULT_PRICE));
        return DEFAULT_PRICE;
    }
}
