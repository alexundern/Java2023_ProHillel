package lesson_12.hw_16;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        findSymbolOccuranceExample();
        findWordPositionExample();
        stringReverseExample();
        isPalindromeExample();
        playGameExample();
    }

    public static void findSymbolOccuranceExample() {
        String str = "Hello, world!";
        char symbol = 'o';
        int occurrence = findSymbolOccurance(str, symbol);
        System.out.println("Number of occurrences of the character '" + symbol + "': " + occurrence);
    }

    public static int findSymbolOccurance(String str, char symbol) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == symbol) {
                count++;
            }
        }
        return count;
    }

    public static void findWordPositionExample() {
        String source1 = "Apollo";
        String target1 = "pollo";
        int position1 = findWordPosition(source1, target1);
        System.out.println("Position of the first occurrence of a substring: " + position1);

        String source2 = "Apple";
        String target2 = "Plant";
        int position2 = findWordPosition(source2, target2);
        System.out.println("Position of the first occurrence of a substring: " + position2);
    }

    public static int findWordPosition(String source, String target) {
        int position = source.indexOf(target);
        return position;
    }

    public static void stringReverseExample() {
        String str = "Hello";
        String reversed = stringReverse(str);
        System.out.println("Reversed line: " + reversed);
    }

    public static String stringReverse(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

    public static void isPalindromeExample() {
        String str1 = "ERE";
        boolean isPalindrome1 = isPalindrome(str1);
        System.out.println("Is the string '" + str1 + "' palindrome? " + isPalindrome1);

        String str2 = "Allo";
        boolean isPalindrome2 = isPalindrome(str2);
        System.out.println("Is the string '" + str2 + "' palindrome? " + isPalindrome2);
    }

    public static boolean isPalindrome(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return str.equals(reversed.reverse().toString());
    }

    public static void playGameExample() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado" , "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        String secretWord = words[randomIndex];

        playGame(secretWord);
    }

    public static void playGame(String secretWord) {
        int wordLength = secretWord.length();
        StringBuilder guessedWord = new StringBuilder(wordLength);
        for (int i = 0; i < wordLength; i++) {
            guessedWord.append("#");
        }

        Scanner scanner = new Scanner(System.in);
        boolean isGuessed = false;

        System.out.println("Guess the word!");
        System.out.println(guessedWord.toString());

        while (!isGuessed) {
            System.out.print("Enter your word: ");
            String guess = scanner.nextLine().toLowerCase();

            if (guess.equals(secretWord)) {
                isGuessed = true;
                System.out.println("Congratulations! You guessed the word!");
            } else {
                int minLen = Math.min(wordLength, guess.length());
                for (int i = 0; i < minLen; i++) {
                    if (guess.charAt(i) == secretWord.charAt(i)) {
                        guessedWord.setCharAt(i, secretWord.charAt(i));
                    }
                }
                System.out.println(guessedWord.toString());
            }
        }

        scanner.close();
    }
}

