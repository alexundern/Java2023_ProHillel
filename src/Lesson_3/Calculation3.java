package Lesson_3;

import java.util.Arrays;
import java.util.Scanner;

public class Calculation3 {

    public void forPrintFrom1to99() {
        for (int i = 1; i <= 99; i += 2) {
            if (i == 99){
                System.out.println(i);
            } else {
                System.out.print(i + ", ");
            }
        }
    }

    public void whilePrintFrom1to99() {
        int a = 1;
        StringBuilder output = new StringBuilder();

        while(a <= 99) {
            output.append(a).append(", ");
            a += 2;
        }

        System.out.println(output.substring(0, output.length() - 2));

    }
    public void forFactorial() {

        int n = 8;
        int factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        System.out.println("Factorial " + n + "! = " + factorial);

    }

    public void whileFactorial() {

        int n = 8;
        int factorial = 1;
        int i = 1;

        while (i <= n) {
            factorial *= i;
            i++;
        }
        System.out.println("Factorial " + n + "! = " + factorial);
    }

    public void doWhilePrintFrom1to99() {

        int num = 1;

        do {
            if (num % 2 == 1) {
                System.out.print(num + " ");
            }
            num++;
        } while (num <= 99);
    }

    public void doWhileFactorial() {

        int n = 8;
        int factorial = 1;
        int i = 1;

        do {
            factorial *= i;
            i++;
        } while (i <= n);

        System.out.println("Factorial " + n + "! = " + factorial);
    }

    public void variablesXandN() {

        int x = 5;
        int n = 3;
        int result = (int) Math.pow(x, n);
        System.out.println(result);
    }


    public void sequences10() {

        int n = 10;
        int currentNumber = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print(currentNumber + ", ");
            currentNumber -= 5;
        }
    }

    public void multiplicationTable () {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the multiplication number: ");

        int x = in.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.print(x + " x " + i + " = " + x * i);
            if (i != 10) {
                System.out.print(", ");
            }
        }
    }

    public void arrayTenOddNumbers() {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = 2 * i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    public void minElementOfArray() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int min = arr[0];
        int i = 1;
        while (i < arr.length) {
            i++;
        }
        System.out.println("The smallest element of the array: " + min);
    }

    public void maxElementOfArray() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("The biggest element of the array: " + max);
    }

    public void swapMinMax() {
        int[] arr = {4, -5, 0, 6, 8};
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            } else if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }

        int temp = arr[minIndex];
        arr[minIndex] = arr[maxIndex];
        arr[maxIndex] = temp;


        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

}
