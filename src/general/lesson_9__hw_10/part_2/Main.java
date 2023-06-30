package general.lesson_9__hw_10.part_2;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Phonebook phonebook = new Phonebook();

        phonebook.add(new Entry("Oleksander Pushkin", "+380950000001"));
        phonebook.add(new Entry("Olexander Block", "+380950000012"));
        phonebook.add(new Entry("Lev Tolstoy", "+380954853311"));
        phonebook.add(new Entry("Ivan Turgenev", "+380954854735"));
        phonebook.add(new Entry("Nikola Tesla", "+380954854735"));
        phonebook.add(new Entry("Ivan Turgenev", "+380957435685"));
        phonebook.add(new Entry("Mikhail Bulgakov", "+380957437745"));
        phonebook.add(new Entry("Vladimir Korolenko", "+380957437245"));
        phonebook.add(new Entry("Tomas Shelby", "+380987435279"));
        phonebook.add(new Entry("Lina Kostenko", "+380972453675"));

        List<Entry> allEntries = phonebook.getAllEntries();
        if (!allEntries.isEmpty()) {
            System.out.println("All entries in the phone book:");
            for (Entry entry : allEntries) {
                System.out.println(entry.getName() + ": " + entry.getPhone());
            }
        } else {
            System.out.println("The phone book is empty.");
        }

        System.out.println("________________________________________________");


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name or phone number to search: ");
        String query = scanner.nextLine();

        Entry foundEntry = phonebook.find(query);
        if (foundEntry != null) {
            System.out.println("Found a record for " + query + ":");
            System.out.println("Name: " + foundEntry.getName());
            System.out.println("Phone: " + foundEntry.getPhone());
        } else {
            System.out.println("No record found for " + query);
        }

        System.out.println("________________________________________________");


        List<Entry> foundEntries = phonebook.findAll(query);
        if (foundEntries != null) {
            System.out.println("Found " + foundEntries.size() + " records for " + query + ":");
            for (Entry entry : foundEntries) {
            System.out.println(entry.getName() + ": " + entry.getPhone());
            }
        } else {
            System.out.println("No records found for " + query);
        }
    }
}


