package com.hillel;

import java.util.ArrayList;
import java.util.List;

public class SortWords {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("test");
        strings.add("Banana");
        strings.add("java");
        strings.add("World");
        strings.add("pear");
        strings.add("Grapes");
        strings.add("home");

        List<String> filteredStrings = filterAndPrint(strings);
        System.out.println("Filtered strings: " + filteredStrings);
    }

    public static List<String> filterAndPrint(List<String> strings) {
        List<String> filteredStrings = new ArrayList<>();

        for (String str : strings) {
            if (str.length() == 4 && str.equals(str.toLowerCase())) {
                filteredStrings.add(str);
                System.out.println(str);
            }
        }

        return filteredStrings;
    }
}
