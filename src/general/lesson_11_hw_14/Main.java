package general.lesson_11_hw_14;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = ArrayValueCalculator.doCalc(array);
            System.out.println("Result: " + result);
        } catch (ArraySizeException e) {
            System.out.println("Array size exception: " + e.getMessage());
        } catch (ArrayDataException e) {
            System.out.println("Array data exception: " + e.getMessage());
        }
    }
}
