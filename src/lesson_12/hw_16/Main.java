package lesson_12.hw_16;

import static lesson_12.hw_16.DataProcessing.findSymbolOccurance;

public class Main {
    public static void main(String[] args) {
        String text = "Hello, world!";
        char symbol = 'o';
        int occurrences = findSymbolOccurance(text, symbol);
        System.out.println("Number of occurrences: " + occurrences);

        DataProcessing.guessWord();
    }
}
