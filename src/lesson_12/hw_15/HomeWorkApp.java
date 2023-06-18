package lesson_12.hw_15;

public class HomeWorkApp {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();

        int number1 = 5;
        int number2 = 15;
        boolean result = isSumInRange(number1, number2);
        System.out.println("Is sum in range: " + result);

        int number = -10;
        printPositiveOrNegative(number);

        int negativeNumber = -7;
        boolean isNegative = isNegativeNumber(negativeNumber);
        System.out.println("Is negative number: " + isNegative);

        String text = "Hello";
        int count = 3;
        printTextMultipleTimes(text, count);

        int year = 2024;
        boolean isLeapYear = isLeapYear(year);
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
        if (sum >= 0) {
            System.out.println("Сума позитивна");
        } else {
            System.out.println("Сума негативна");
        }
    }

    public static void printColor() {
        int value = 75;
        if (value <= 0) {
            System.out.println("Червоний");
        } else if (value <= 100) {
            System.out.println("Жовтий");
        } else {
            System.out.println("Зелений");
        }
    }

    public static void compareNumbers() {
        int a = 10;
        int b = 5;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void printPositiveOrNegative(int number) {
        if (number >= 0) {
            System.out.println("Додатнє число");
        } else {
            System.out.println("Від'ємне число");
        }
    }

    public static boolean isNegativeNumber(int number) {
        return number < 0;
    }

    public static void printTextMultipleTimes(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }
}
