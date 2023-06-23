package lesson_12.hw_15;

import java.util.stream.*;

public class HomeWorkApp {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();

        int number1 = 5;
        int number2 = 15;
        boolean result = sumInRange(number1, number2);
        System.out.println("Is sum in range: " + result);

        int number = -10;
        printPositiveOrNegative(number);

        int negativeNumber = -7;
        boolean isNegative = isNegativeNumber(negativeNumber);
        System.out.println("Is negative number: " + isNegative);

        String text = "Text Multiple Times";
        int count = 5;
        printTextMultipleTimes(text, count);

        int year = 2024;
        boolean isLeapYear = leapYear(year);
        System.out.println("Is leap year: " + isLeapYear);
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 5;
        int b = -3;
        int sum = a + b;
        String result = sum >= 0 ? "The sum is positive" : "The sum is negative";
        System.out.println(result);
    }

    public static void printColor() {
        int value = 175;
        String color = value <= 0 ? "Red" : value <= 100 ? "Yellow" : "Green";
        System.out.println(color);
    }

    public static void compareNumbers() {
        int a = 10;
        int b = 25;
        String result = a >= b ? "a >= b" : "a < b";
        System.out.println(result);
    }

    public static boolean sumInRange(int a, int b) {
        int sum = a + b;
        return IntStream.rangeClosed(10, 20).anyMatch(i -> i == sum);
    }

    public static void printPositiveOrNegative(int number) {
        String result = number >= 0 ? "A positive number" : "A negative number";
        System.out.println(result);
    }

    public static boolean isNegativeNumber(int number) {
        return IntStream.of(number).anyMatch(n -> n < 0);
    }

    public static void printTextMultipleTimes(String text, int count) {
        Stream.generate(() -> text).limit(count).forEach(System.out::println);
    }

    public static boolean leapYear(int year) {
        return Stream.of(year)
                .filter(y -> y % 4 == 0)
                .filter(y -> y % 100 != 0)
                .filter(y -> y % 400 == 0)
                .findAny()
                .isPresent();
    }
}
