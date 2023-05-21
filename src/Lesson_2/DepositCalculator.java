package Lesson_2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");
        String currencySymbol = " UAH";

        System.out.print("Enter the amount of the cash deposit in UAH: ");
        double amount = input.nextDouble();

        System.out.print("Enter the % paid by the bank per year: ");
        double interestRate = input.nextDouble();

        System.out.print("Enter the duration of the deposit in years: ");
        int years = input.nextInt();

        double monthlyRate = interestRate / 12 / 100;
        double balance = amount;

        for (int i = 1; i <= years; i++) {
            double interest = balance * monthlyRate;
            double monthInterest = balance / 12;
            balance += interest;

            System.out.println("Year " + i + ":");
            System.out.println("Initial balance: " + df.format(amount) + currencySymbol);
            System.out.println("Accrued interest per year: " + df.format(interest) + currencySymbol);
            System.out.println("Accrued interest per month: " + df.format(monthInterest) + currencySymbol);
            System.out.println("Total balance for " + i + " year:" + " " + df.format(balance) + currencySymbol);
            amount = balance;
        }
    }

}
