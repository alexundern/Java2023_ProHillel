package general.lesson_3;

public class SystemOutPrint3 {

    public static void main(String[] args) {
        Calculation3 hw = new Calculation3();

        System.out.println("Task 1: For 1 - 99.");
        hw.forPrintFrom1to99();
        System.out.println("______________________");

        System.out.println("Task 2: For Factorial.");
        hw.forFactorial();
        System.out.println("______________________");

        System.out.println("Task 3: While 1 - 99.");
        hw.whilePrintFrom1to99();
        System.out.println("______________________");

        System.out.println("Task 3: While factorial.");
        hw.whileFactorial();
        System.out.println("______________________");

        System.out.println("Task 4: Do While 1 - 99.");
        hw.doWhilePrintFrom1to99();
        System.out.println();
        System.out.println("______________________");

        System.out.println("Task 4: Do While factorial.");
        hw.doWhileFactorial();
        System.out.println("______________________");

        System.out.println("Task 5: Variables");
        hw.variablesXandN();
        System.out.println("______________________");

        System.out.println("Task 6: The first 10 numbers of the sequence 0, -5, -10, -15.");
        hw.sequences10();
        System.out.println();
        System.out.println("______________________");

        System.out.println("Task 7: Multiplication table.");
        hw.multiplicationTable();
        System.out.println();
        System.out.println("______________________");

        System.out.println("Task 8: Aarray the first 10 odd numbers.");
        hw.arrayTenOddNumbers();
        System.out.println("______________________");

        System.out.println("Task 9: Array {1, 3, 5, 7, 9, 11, 13, 15, 17, 19}");
        hw.minElementOfArray();
        System.out.println("______________________");

        System.out.println("Task 10: Max Array from task 9.");
        hw.maxElementOfArray();
        System.out.println("______________________");

        System.out.println("Task 11: Swap Min and Max element of massive.");
        hw.swapMinMax();
        System.out.println("\n__________");
    }

}
