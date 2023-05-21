package Lesson_2;

import java.text.DecimalFormat;
import java.util.Scanner;
public class AverageXNum {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.print("Enter quantity of numbers: ");
        double count = input.nextInt();

        double sum = 0;
        for (int i = 0; i < count; i++) {
            System.out.print("Enter the number " + (i+1) + ": ");
            double num = input.nextDouble();
            sum += num;
        }

        double average = sum / count;

        System.out.println("Average of numbers: " + df.format(average));
    }

}
