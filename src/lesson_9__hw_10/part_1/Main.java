package lesson_9__hw_10.part_1;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> wordList = Arrays.asList("bird", "cat", "cat", "dog",
                "tiger", "cat", "dog", "bird", "fox", "cat");
        String wordToCount = "cat";
        int occurrenceCount = countOccurrence(wordList, wordToCount);
        System.out.println("Occurrences of '" + wordToCount + "': " + occurrenceCount);

        Integer[] array = {1, 2, 3};
        List<Integer> list = toList(array);
        System.out.println("List: " + list);

        List<Integer> numberList = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> uniqueList = findUnique(numberList);
        System.out.println("Unique numbers: " + uniqueList);

        calcOccurrence(wordList);

        List<Occurrence> occurrenceList = Occurrence.findOccurrence(wordList);
        System.out.println("Occurrences List: " + "\n" + occurrenceList);
    }

    public static int countOccurrence(List<String> wordList, String wordToCount) {
        int count = 0;
        for (String word : wordList) {
            if (word.equals(wordToCount)) {
                count++;
            }
        }
        return count;
    }

    public static <T> List<T> toList(T[] array) {
        return Arrays.asList(array);
    }

    public static List<Integer> findUnique(List<Integer> numberList) {
        Set<Integer> uniqueSet = new HashSet<>(numberList);
        return new ArrayList<>(uniqueSet);
    }

    public static void calcOccurrence(List<String> wordList) {
        Map<String, Integer> occurrenceMap = new HashMap<>();
        for (String word : wordList) {
            occurrenceMap.put(word, occurrenceMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : occurrenceMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    static class Occurrence {
        String name;
        int occurrence;

        public Occurrence(String name, int occurrence) {
            this.name = name;
            this.occurrence = occurrence;
        }

        @Override
        public String toString() {
//            return "\n {name: \"" + name + "\", occurrence: " + occurrence + "}\n";
            return "{name: \"" + name + "\", occurrence: " + occurrence + "}";
        }

        public static List<Occurrence> findOccurrence(List<String> wordList) {
            Map<String, Integer> occurrenceMap = new HashMap<>();
            for (String word : wordList) {
                occurrenceMap.put(word, occurrenceMap.getOrDefault(word, 0) + 1);
            }
            List<Occurrence> occurrenceList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : occurrenceMap.entrySet()) {
                occurrenceList.add(new Occurrence(entry.getKey(), entry.getValue()));
            }
            return occurrenceList;
        }
    }
}


