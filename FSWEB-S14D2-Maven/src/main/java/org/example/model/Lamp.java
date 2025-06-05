package org.example.model;
import org.example.model.enums.LampType;

public class Lamp {
    private int globRating;
    private boolean battery;
    private LampType style;

    public Lamp(LampType style,  boolean battery, int globRating ) {
        this.globRating = globRating;
        this.battery = battery;
        this.style = style;
    }

    public void turnOn() {
        System.out.println("Lamp is being turned on.");
    }

    public LampType getStyle() {
        return style;
    }

    public boolean isBattery() {
        return battery;
    }


    public int getGlobRating() {
        return globRating;
    }
}
