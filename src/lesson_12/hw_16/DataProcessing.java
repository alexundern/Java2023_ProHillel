package lesson_12.hw_16;

import java.util.Scanner;
import java.util.Random;


public class DataProcessing {
        public static int findSymbolOccurance(String text, char symbol) {
            int count = 0;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == symbol) {
                    count++;
                }
            }
            return count;
        }

    public static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    public static String stringReverse(String text) {
        StringBuilder reversed = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed.append(text.charAt(i));
        }
        return reversed.toString();
    }

    public static boolean isPalindrome(String text) {
        String reversed = stringReverse(text);
        return text.equalsIgnoreCase(reversed);
    }

    public static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        int index = random.nextInt(words.length);
        String wordToGuess = words[index];

        Scanner scanner = new Scanner(System.in);
        boolean guessed = false;

        System.out.println("Guess the word!");

        while (!guessed) {
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine().toLowerCase();

            if (guess.equals(wordToGuess)) {
                System.out.println("Congratulations! You guessed the word.");
                guessed = true;
            } else {
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (i < guess.length() && guess.charAt(i) == wordToGuess.charAt(i)) {
                        System.out.print(wordToGuess.charAt(i));
                    } else {
                        System.out.print("#");
                    }
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}
