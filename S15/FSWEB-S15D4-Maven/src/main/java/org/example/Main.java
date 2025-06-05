package org.example;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");



        String pelin = "pelin";
        System.out.println(Main.checkForPalindrome(pelin));

    }


    public static boolean checkForPalindrome(String str) {
        String original = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String reversed = new StringBuilder(original).reverse().toString();
        if (original.equals(reversed)) {return true;}
        return false;
    }

    public static String  convertDecimalToBinary(int number) {
        // String output = Integer.toBinaryString(number);
        StringBuilder str = new StringBuilder();

        if (number == 0) {
            return "0";
        }


        while (number!=0) {
            int remainder = number%2;
            String toInsert = String.valueOf(remainder);
            str.insert(0, toInsert);
            number = number/2; // automatically ignores the decimal part
        }
        String output= str.toString();
        return output ;
    }


}