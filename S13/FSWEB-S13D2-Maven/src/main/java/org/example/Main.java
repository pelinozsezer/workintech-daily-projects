package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // 🔁 Check if a number is a palindrome
    public static boolean isPalindrome(int num) {
        int number = Math.abs(num);
        int original = number;
        int reversed = 0;

        while (number != 0) {
            int rightDigit = number % 10;
            reversed = reversed * 10 + rightDigit;
            number /= 10;
        }

        return original == reversed;
    }

    // ✅ Check if a number is a perfect number
    public static boolean isPerfectNumber(int num) {
        if (num <= 1) return false;

        int sum = 1;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        return sum == num;
    }

    // 🔤 Convert number to words (0-9)
    public static String numberToWords(int num) {
        if (num < 0) return "Invalid Value";

        String[] digits = Integer.toString(num).split("");
        StringBuilder result = new StringBuilder();

        for (String digit : digits) {
            switch (digit) {
                case "0": result.append(" Zero"); break;
                case "1": result.append(" One"); break;
                case "2": result.append(" Two"); break;
                case "3": result.append(" Three"); break;
                case "4": result.append(" Four"); break;
                case "5": result.append(" Five"); break;
                case "6": result.append(" Six"); break;
                case "7": result.append(" Seven"); break;
                case "8": result.append(" Eight"); break;
                case "9": result.append(" Nine"); break;
            }
        }

        return result.toString().trim();
    }
}
