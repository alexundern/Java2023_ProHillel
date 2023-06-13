package lesson_9__Hw_10.Part_2;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {

    private List<Entry> entries;

    public Phonebook() {
        entries = new ArrayList<>();
    }

    public void add(Entry entry) {
        entries.add(entry);
    }

    public Entry find(String query) {
        for (Entry entry : entries) {
            if (entry.getName().equals(query) || entry.getPhone().equals(query)) {
                return entry;
            }
        }
        return null;
    }

    public List<Entry> findAll(String query) {
        List<Entry> foundEntries = new ArrayList<>();
        List<String> matchingPhones = new ArrayList<>();

        for (Entry entry : entries) {
            if (entry.getName().equals(query) || entry.getPhone().equals(query)) {
                foundEntries.add(entry);
                if (entry.getName().equals(query)) {
                    matchingPhones.add(entry.getPhone());
                }
            }
        }

        if (foundEntries.isEmpty()) {
            return null;
        }

        if (matchingPhones.size() > 1) {
            System.out.println("Duplicate phones found for name " + query + ":");
            for (Entry entry : foundEntries) {
                if (matchingPhones.contains(entry.getPhone())) {
                    System.out.println(entry.getName() + ": " + entry.getPhone());
                }
            }
        }

        return foundEntries;
    }

    public List<Entry> getAllEntries() {
        return entries;
    }
}






