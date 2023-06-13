package lesson_8_hw_9;

public class Main {

    public static void main(String[] args) {

        CollectionList collection = new CollectionList();

        collection.add("Zero", collection.list);
        collection.add("One", collection.list);
        collection.add("Two", collection.list);
        collection.add(2, "Ten");
        System.out.println("List after adding elements: " + collection.list);
        System.out.println("______________________________________________");

        collection.add(1, "Fourteen");
        System.out.println("List after adding 'Fourteen' at index 1: " + collection.list);
        System.out.println("______________________________________________");

        System.out.println("Elements at index 3: " + collection.get(3));
        System.out.println("Elements at index 1: " + collection.get(1));
        System.out.println("______________________________________________");

        collection.add(3, "Five");
        System.out.println("List after adding 'Five' at index 3: " + collection.list);
        System.out.println("______________________________________________");

        System.out.println("Elements contains 'One': " + collection.contains("One"));
        System.out.println("Elements contains 'Fifty': " + collection.contains("Fifty"));
        System.out.println("______________________________________________");

        collection.delete("Nine");
        System.out.println("Size after delete 'Nine': " + collection.size());
        System.out.println("List after delete elements: " + collection.list);
        System.out.println("______________________________________________");

        collection.clear();
        System.out.println("Size after clear elements: " + + collection.size());
        System.out.println("List after clear elements: " + collection.list);

    }
}
