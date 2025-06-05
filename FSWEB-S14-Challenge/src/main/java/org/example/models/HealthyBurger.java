package org.example.models;

public class HealthyBurger extends  Hamburger{

    private static final String DEFAULT_MEAT="Tofu";
    private String healthyExtra1Name;
    private double healthyExtra1Price;
    private String healthyExtra2Name;
    private double healthyExtra2Price;

    public HealthyBurger(String name, double price, String breadRollType) {

        super(name, DEFAULT_MEAT, price, breadRollType);
    }

    public void addHealthyAddition1(String healthyExtra1Name, double healthyExtra1Price) {
        this.healthyExtra1Name=healthyExtra1Name;
        this.healthyExtra1Price= healthyExtra1Price;
        addHamburgerAddition1(healthyExtra1Name,healthyExtra1Price);
    };
    public void addHealthyAddition2(String healthyExtra2Name, double healthyExtra2Price) {
        this.healthyExtra2Name=healthyExtra2Name;
        this.healthyExtra2Price= healthyExtra2Price;
        addHamburgerAddition2(healthyExtra2Name,healthyExtra2Price);
    };

    @Override
    public double itemizeHamburger() {
        String str = String.format("%s %f %s %f %s %f" ,
                getName(),getPrice(),
                healthyExtra1Name,healthyExtra1Price,
                healthyExtra2Name, healthyExtra2Price);
        System.out.println(str);
        return getPrice();
    }
}
