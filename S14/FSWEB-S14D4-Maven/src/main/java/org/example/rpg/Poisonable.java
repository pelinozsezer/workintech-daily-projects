package org.example.rpg;

public interface Poisonable {
    double getDamage();
    default public double poison() {return getDamage()*0.3;};
}
