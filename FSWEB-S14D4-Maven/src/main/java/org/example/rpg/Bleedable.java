package org.example.rpg;

public interface Bleedable {
    double getDamage();
    default double bleed() {return getDamage()*0.25;};
}
