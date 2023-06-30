package general.lesson_7_hw_8;

public class Main {
    public static void main(String[] args) {

        CollectionList collection = new CollectionList();

        // Adding elements to the list
        collection.add("Zero", collection.list);
        collection.add("One", collection.list);
        collection.add("Two", collection.list);
        collection.add("Three", collection.list);
        collection.add("Four", collection.list);
        collection.add(5,"Five", collection.list);
        collection.add(6,"Six", collection.list);
        collection.add(7,"Seven", collection.list);
        collection.add(8,"Eight", collection.list);
        collection.add(9,"Nine", collection.list);
        collection.add(10,"Ten", collection.list);
        collection.add(11,"Eleven", collection.list);
        collection.add(12,"Twelve", collection.list);
        collection.add(13,"Thirteen", collection.list);

        System.out.println("List after adding elements: " + collection.list);

        collection.add(1, "Fourteen", collection.list);
        System.out.println("List after adding '14' at index 1: " + collection.list);

        // Deleting an element by value
        collection.delete("Ten", collection.list);
        System.out.println("List after deleting Ten: " + collection.list);

        // Deleting an element by index
        collection.delete(2, collection.list);
        System.out.println("List after deleting element at index 2: " + collection.list);

        // Getting an element by index
        String element = collection.get(1, collection.list);
        System.out.println("Element at index 1: " + element);

    }
}


