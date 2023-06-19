package com.hillel;

import javafx.util.Pair;
import java.util.List;
import java.util.stream.Collectors;

public class StringConverter {
    public static List<Pair<String, String>> convertToUpperCase(List<String> strings) {
        return strings.stream()
                .map(str -> new Pair<>(str, str.toUpperCase()))
                .collect(Collectors.toList());
    }
}
