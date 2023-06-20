package com.hillel;

import java.util.List;
import java.util.stream.Collectors;

public class SortWords {
    public static List<String> sortWords(List<String> strings) {
        return strings.stream()
                .filter(s -> s.toLowerCase().equals(s) && s.length() == 4)
                .collect(Collectors.toList());
    }
}
