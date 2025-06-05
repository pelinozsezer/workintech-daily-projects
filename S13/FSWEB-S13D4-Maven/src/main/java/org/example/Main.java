package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//        Point first = new Point(6, 5);
//        Point second = new Point(3, 1);
//        System.out.println("distance(0,0)= " + first.distance());
//        System.out.println("distance(second)= " + first.distance(second));
//        System.out.println("distance(2,2)= " + first.distance(2, 2));
//        Point point = new Point(0,0);
//        System.out.println("distance()= " + point.distance());

        Player player = new Player("Pelin", 25, Weapon.SWORD);
        System.out.println("Health: " + player.healthRemaining());

        player.loseHealth(50);
        System.out.println("After damage: " + player.healthRemaining());

        player.restoreHealth(60);
        System.out.println("After healing: " + player.healthRemaining());


    }
}