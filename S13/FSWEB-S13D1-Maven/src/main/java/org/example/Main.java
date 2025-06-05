package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // Barking dog logic
    public static boolean shouldWakeUp(boolean isBarking, int clock) {
        if (isBarking && clock >= 0 && clock < 24) {
            return clock < 8 || clock >= 20;
        }
        return false;
    }

    // Teen number check
    public static boolean hasTeen(int firstAge, int secondAge, int thirdAge) {
        return (firstAge >= 13 && firstAge <= 19) ||
                (secondAge >= 13 && secondAge <= 19) ||
                (thirdAge >= 13 && thirdAge <= 19);
    }

    // Cat playing temperature check
    public static boolean isCatPlaying(boolean isSummer, int temp) {
        if (isSummer) {
            return temp >= 25 && temp <= 45;
        } else {
            return temp >= 25 && temp <= 35;
        }
    }

    // Area of a rectangle
    public static double area(double width, double height) {
        if (width > 0 && height > 0) {
            return width * height;
        } else {
            return -1;
        }
    }

    // Area of a circle
    public static double area(double radius) {
        if (radius > 0) {
            return Math.pow(radius, 2) * Math.PI;
        } else {
            return -1;
        }
    }
}
